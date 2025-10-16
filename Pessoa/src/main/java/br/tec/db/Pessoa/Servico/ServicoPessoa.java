package br.tec.db.Pessoa.Servico;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.tec.db.Pessoa.dto.PessoaDto;
import br.tec.db.Pessoa.modelo.Pessoa;
import br.tec.db.Pessoa.modelo.PessoaMapperInterface;
import br.tec.db.Pessoa.repositorio.RepositorioPessoa;
import jakarta.persistence.EntityNotFoundException;

/**
 * ServicoPessoa
 */
@Service
public class ServicoPessoa {

  @Autowired
  RepositorioPessoa repositorioPessoa;

  public ResponseEntity<List<PessoaDto>> listaPessoa() {
    List<Pessoa> listaPessoa = repositorioPessoa.findAll();
    List<PessoaDto> listaDto = listaPessoa.stream().map(PessoaMapperInterface.INSTANCE::pessoaDto)
        .collect(Collectors.toList());
    return ResponseEntity.ok(listaDto);
  }

  public PessoaDto salvarPessoa(Pessoa pessoa) {
    repositorioPessoa.save(pessoa);
    PessoaDto pessoaDto = PessoaMapperInterface.INSTANCE.pessoaDto(pessoa);

    return pessoaDto;
  }

  public ResponseEntity<PessoaDto> findById(Long id) {
    Optional<Pessoa> pessoa = repositorioPessoa.findById(id);
    if (pessoa.isPresent()) {

      PessoaDto pessoaDto = PessoaMapperInterface.INSTANCE.pessoaDto(pessoa.get());
      return ResponseEntity.ok(pessoaDto);
    }
    return ResponseEntity.notFound().build();

  }

  public void deletarPessoa(Long id) {
    Pessoa pessoa = repositorioPessoa.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com id: " + id));
    repositorioPessoa.delete(pessoa);
  }
}
