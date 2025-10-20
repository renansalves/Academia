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

  @Autowired
  private ServicoPessoa servicoPessoa;

  @PostMapping
  public ResponseEntity<PessoaDto> salvarPessoa(@RequestBody PessoaDto pessoaDto) {

    PessoaDto pessoaSalva = servicoPessoa.salvarPessoa(pessoaDto);

    URI recurso = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("{id}")
        .buildAndExpand(pessoaSalva.id())
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
    PessoaDto pessoaDto = servicoPessoa.listarUmaPessoaPorId(id);
    return ResponseEntity.ok(pessoaDto);
  }

  @PutMapping("{id}")
  public ResponseEntity<PessoaDto> atualizarPessoa(@PathVariable("id") Long id, @RequestBody PessoaDto pessoaDto) {
    PessoaDto pessoaAtualizada = servicoPessoa.atualizarPessoa(id, pessoaDto);

    return ResponseEntity.ok(pessoaAtualizada);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> deletarPessoa(@PathVariable("id") Long id) {
    servicoPessoa.deletarPessoa(id);

    return ResponseEntity.noContent().build();
  }
}
