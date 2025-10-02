package br.tec.db.veiculos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.tec.db.veiculos.dto.VeiculoDto;
import br.tec.db.veiculos.service.VeiculoService;

@RestController
@RequestMapping("veiculos")
public class VeiculosController {

  @Autowired
  VeiculoService veiculoService;

  @GetMapping()
  public List<VeiculoDto> listarTodos() {
    return veiculoService.listarVeiculos();
  }

  @DeleteMapping(path = "{id}")
  public ResponseEntity<Void> remover(@PathVariable("id") Long id) {

    if (veiculoService.deletarVeiculo(id)) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }

}
