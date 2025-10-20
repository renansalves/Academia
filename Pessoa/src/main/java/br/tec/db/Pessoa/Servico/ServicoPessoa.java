package br.tec.db.Pessoa.Servico;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.tec.db.Pessoa.dto.PessoaDto;
import br.tec.db.Pessoa.excecao.PessoaNaoEncontradaExcecao;
import br.tec.db.Pessoa.map.EnderecoMapperInterface;
import br.tec.db.Pessoa.map.PessoaMapperInterface;
import br.tec.db.Pessoa.modelo.Endereco;
import br.tec.db.Pessoa.modelo.Pessoa;
import br.tec.db.Pessoa.repositorio.RepositorioPessoa;
import lombok.RequiredArgsConstructor;

/**
 * ServicoPessoa
 */
@Service
@RequiredArgsConstructor
public class ServicoPessoa {

  private final EnderecoMapperInterface enderecoMapper;
  private final PessoaMapperInterface pessoaMapper;
  private final RepositorioPessoa repositorioPessoa;

  // Retorna o DTO da entidade salva para o Controller construir a resposta 201
  // Created
  public PessoaDto salvarPessoa(PessoaDto pessoaDto) {
    // O DTO de entrada não deve ter ID, MapStruct trata isso.
    Pessoa pessoaEntidade = pessoaMapper.toEntity(pessoaDto);
    Pessoa entidadeSalva = repositorioPessoa.save(pessoaEntidade);

    return pessoaMapper.toDto(entidadeSalva);
  }

  // Retorna o DTO ou lança PessoaNotFoundException (que será mapeada para 404)
  public PessoaDto listarUmaPessoaPorId(Long id) {
    Pessoa pessoa = repositorioPessoa.findById(id)
        .orElseThrow(() -> new PessoaNaoEncontradaExcecao("Pessoa não encontrada com id: " + id));

    return pessoaMapper.toDto(pessoa);
  }

  // Retorna a lista de DTOs (pode ser vazia, resultando em 200 OK com [] )
  public List<PessoaDto> listarPessoas() {
    return repositorioPessoa.findAll().stream()
        .map(pessoaMapper::toDto)
        .collect(Collectors.toList());
  }

  // Retorna o DTO atualizado ou lança PessoaNotFoundException
  public PessoaDto atualizarPessoa(Long id, PessoaDto pessoaDto) {
    Pessoa entidadePessoa = repositorioPessoa.findById(id)
        .orElseThrow(() -> new PessoaNaoEncontradaExcecao("Pessoa não encontrada para atualização com id: " + id));

    // Atualização parcial de campos (melhorado para ser mais conciso)
    if (pessoaDto.nome() != null)
      entidadePessoa.setNome(pessoaDto.nome());
    if (pessoaDto.cpf() != null)
      entidadePessoa.setCpf(pessoaDto.cpf());
    if (pessoaDto.dataNascimento() != null)
      entidadePessoa.setDataNascimento(pessoaDto.dataNascimento());

    // Tratamento da lista de endereços: substitui a lista existente
    if (pessoaDto.enderecos() != null) {
      // 1. Mapeia a nova lista de DTOs para Entidades
      List<Endereco> novosEnderecos = pessoaDto.enderecos().stream()
          .map(enderecoMapper::toEntity)
          .collect(Collectors.toList());

      // 2. Limpa a coleção gerenciada (Isso dispara a remoção dos órfãos)
      entidadePessoa.getEnderecos().clear();

      // 3. Adiciona todos os novos itens à coleção gerenciada
      entidadePessoa.getEnderecos().addAll(novosEnderecos);
    }

    Pessoa entidadeAtualizada = repositorioPessoa.save(entidadePessoa);
    return pessoaMapper.toDto(entidadeAtualizada);
  }

  // Deleta o recurso. Lança PessoaNotFoundException se não encontrar. Retorna
  // void.
  public void deletarPessoa(Long id) {
    Pessoa pessoa = repositorioPessoa.findById(id)
        .orElseThrow(() -> new PessoaNaoEncontradaExcecao("Pessoa não encontrada para deleção com id: " + id));

    // A deleção por objeto é necessária aqui para manter a verificação 404
    repositorioPessoa.delete(pessoa);
  }
}
