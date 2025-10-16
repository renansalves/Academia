package br.tec.db.Pessoa.controlador;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.tec.db.Pessoa.Servico.ServicoPessoa;
import br.tec.db.Pessoa.dto.PessoaDto;
import br.tec.db.Pessoa.modelo.Pessoa;
import br.tec.db.Pessoa.modelo.PessoaMapperInterface;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ControladorPessoa
 */
@RestController
@RequestMapping("pessoa")
public class ControladorPessoa {

  @Autowired
  ServicoPessoa servicoPessoa;

  @PostMapping()
  public ResponseEntity<PessoaDto> salvarPessoa(@RequestBody PessoaDto pessoa) {

    Pessoa pessoaEntidade = PessoaMapperInterface.INSTANCE.pessoa(pessoa);
    PessoaDto pessoaDto = servicoPessoa.salvarPessoa(pessoaEntidade);

    URI recurso = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoaEntidade.getId())
        .toUri();

    return ResponseEntity.created(recurso).body(pessoaDto);
  }

}
