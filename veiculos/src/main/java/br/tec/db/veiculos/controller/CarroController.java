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

import br.tec.db.veiculos.dto.CarroDto;
import br.tec.db.veiculos.model.Carro;
import br.tec.db.veiculos.service.CarroService;

@RestController
@RequestMapping("veiculos")
public class CarroController {

  @Autowired
  CarroService carroService;

  @PostMapping(path = "carro")
  public CarroDto salvar(@RequestBody Carro carro) {
    return carroService.salvarCarro(carro);
  }

  @GetMapping(path = "carro/{id}")
  public ResponseEntity<CarroDto> obterPorId(@PathVariable("id") Long id) {
    return carroService.listaCarroPorId(id);
  }

  @PutMapping(path = "carro/{id}")
  public ResponseEntity<CarroDto> atualizar(@PathVariable("id") Long id, @RequestBody Carro carroAtualizado) {
    return carroService.atualizarCarro(carroAtualizado, id);
  }

}
