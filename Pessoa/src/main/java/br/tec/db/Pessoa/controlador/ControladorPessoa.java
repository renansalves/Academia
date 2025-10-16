package br.tec.db.Pessoa.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

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
  public ResponseEntity<PessoaDto> salvar(@RequestBody PessoaDto pessoaDto) {

    Pessoa pessoa = PessoaMapperInterface.INSTANCE.pessoa(pessoaDto);
    PessoaDto retornoPessoaDto = servicoPessoa.salvarPessoa(pessoa);
    return ResponseEntity.ok(retornoPessoaDto);
  }

}
