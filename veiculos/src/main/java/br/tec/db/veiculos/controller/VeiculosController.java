package br.tec.db.veiculos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.tec.db.veiculos.model.Veiculo;
import br.tec.db.veiculos.repository.VeiculosRepository;

@RestController
@RequestMapping("veiculos")
public class VeiculosController {

  @Autowired
  VeiculosRepository veiculosRepository;

  @GetMapping()
  public List<Veiculo> listarTodos() {
    return veiculosRepository.findAll();
  }

  @DeleteMapping(path = "{id}")
  public ResponseEntity<Void> remover(@PathVariable("id") Long id) {
    if (veiculosRepository.existsById(id)) {
      veiculosRepository.deleteById(id);
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }

}
