
package br.tec.db.veiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.tec.db.veiculos.dto.MotoDto;
import br.tec.db.veiculos.model.Moto;
import br.tec.db.veiculos.service.MotoService;

@RestController
@RequestMapping("veiculos")
public class MotoController {

  @Autowired
  MotoService motoService;

  @PostMapping(path = "moto")
  public MotoDto salvar(@RequestBody Moto moto) {
    return motoService.salvarMoto(moto);
  }

  @GetMapping(path = "moto/{id}")
  public ResponseEntity<MotoDto> obterPorId(@PathVariable("id") Long id) {
    return motoService.listaMotoPorId(id);
  }

  @PutMapping(path = "moto/{id}")
  public ResponseEntity<MotoDto> atualizar(@PathVariable("id") Long id, @RequestBody Moto motoAtualizada) {
    return motoService.atualizarMoto(motoAtualizada, id);
  }

}
