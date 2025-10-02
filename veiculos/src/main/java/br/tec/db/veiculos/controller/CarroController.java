package br.tec.db.veiculos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.tec.db.veiculos.model.Carro;
import br.tec.db.veiculos.repository.CarroRepository;

@RestController
@RequestMapping("veiculos")
public class CarroController {

  @Autowired
  CarroRepository carroRepository;

  @PostMapping(path = "carro")
  public Carro salvar(@RequestBody Carro carro) {
    return carroRepository.save(carro);
  }

  @GetMapping(path = "carro/{id}")
  public ResponseEntity<Carro> obterPorId(@PathVariable("id") Long id) {
    return carroRepository.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping(path = "carro")
  public List<Carro> listarTodos() {
    return carroRepository.findAll();
  }

  @PutMapping(path = "carro/{id}")
  public ResponseEntity<Carro> atualizar(@PathVariable("id") Long id, @RequestBody Carro carroAtualizado) {
    return carroRepository.findById(id)
        .map(carro -> {
          carro.setMarca(carroAtualizado.getMarca());
          carro.setTipo(carroAtualizado.getTipo());
          carro.setModelo(carroAtualizado.getModelo());
          carro.setNumeroPortas(carroAtualizado.getNumeroPortas());
          return ResponseEntity.ok(carroRepository.save(carro));
        })
        .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping(path = "carro/{id}")
  public ResponseEntity<Void> remover(@PathVariable("id") Long id) {
    if (carroRepository.existsById(id)) {
      carroRepository.deleteById(id);
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}
