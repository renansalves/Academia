package br.tec.db.Pessoa.controlador;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping; // Importado
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping; // Adicionado para Atualização
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.tec.db.Pessoa.Servico.ServicoPessoa;
import br.tec.db.Pessoa.dto.PessoaDto;

/**
 * ControladorPessoa
 */
@RestController
@RequestMapping("pessoa")
public class ControladorPessoa {

  // Prática recomendada é usar Injeção via Construtor (Adicionar
  // @RequiredArgsConstructor
  // e tornar os campos 'final' ou usar um construtor explícito),
  // mas mantendo @Autowired para consistência com o código original.
  @Autowired
  private ServicoPessoa servicoPessoa;

  @PostMapping
  public ResponseEntity<PessoaDto> salvarPessoa(@RequestBody PessoaDto pessoaDto) {

    PessoaDto pessoaSalva = servicoPessoa.salvarPessoa(pessoaDto);

    // Constrói a URI para o recurso criado (padrão 201 Created)
    URI recurso = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("{id}")
        .buildAndExpand(pessoaSalva.id()) // Usa o ID do DTO retornado
        .toUri();

    return ResponseEntity.created(recurso).body(pessoaSalva);
  }

  @GetMapping
  public ResponseEntity<List<PessoaDto>> listarPessoas() {
    List<PessoaDto> pessoas = servicoPessoa.listarPessoas();
    return ResponseEntity.ok(pessoas);
  }

  @GetMapping("{id}")
  public ResponseEntity<PessoaDto> obterPessoa(@PathVariable("id") Long id) {
    // Se a Pessoa não for encontrada, o serviço lançará PessoaNotFoundException (->
    // 404)
    PessoaDto pessoaDto = servicoPessoa.listarUmaPessoaPorId(id);
    return ResponseEntity.ok(pessoaDto);
  }

  @PutMapping("{id}") // Novo método para atualização
  public ResponseEntity<PessoaDto> atualizarPessoa(@PathVariable("id") Long id, @RequestBody PessoaDto pessoaDto) {
    PessoaDto pessoaAtualizada = servicoPessoa.atualizarPessoa(id, pessoaDto);

    // Retorna 200 OK ou 201 Created se o endpoint de atualização for o mesmo do
    // POST.
    // 200 OK é mais comum para PUT.
    return ResponseEntity.ok(pessoaAtualizada);
  }

  @DeleteMapping("{id}") // Novo método para deleção
  public ResponseEntity<Void> deletarPessoa(@PathVariable("id") Long id) {
    // Se a Pessoa não for encontrada, o serviço lançará PessoaNotFoundException (->
    // 404)
    servicoPessoa.deletarPessoa(id);

    // Retorna 204 No Content (padrão REST para deleção bem-sucedida)
    return ResponseEntity.noContent().build();
  }
}
