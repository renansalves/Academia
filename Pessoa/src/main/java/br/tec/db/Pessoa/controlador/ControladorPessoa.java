package br.tec.db.Pessoa.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.tec.db.Pessoa.Servico.ServicoPessoa;
import br.tec.db.Pessoa.dto.PessoaDto;
import br.tec.db.Pessoa.modelo.Pessoa;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * ControladorPessoa
 */
@RestController("/pessoa")
public class ControladorPessoa {

  @Autowired
  ServicoPessoa servicoPessoa;

@PostMapping(path = "/")
  public PessoaDto salvar(@RequestBody Pessoa pessoa) {
    return servicoPessoa.salvarPessoa(pessoa);
    
  }
    

}

