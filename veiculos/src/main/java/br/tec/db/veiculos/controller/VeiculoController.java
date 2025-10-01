
package br.tec.db.veiculos.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.tec.db.veiculos.model.Moto;

@RestController
@RequestMapping("veiculos")
public class VeiculoController {

  @PostMapping("moto")
  public void salvar(@RequestBody Moto moto) {
    System.out.println("Moto: " + moto);
  }
}
