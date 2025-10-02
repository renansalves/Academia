
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

import br.tec.db.veiculos.model.Moto;
import br.tec.db.veiculos.repository.MotoRepository;

@RestController
@RequestMapping("veiculos")
public class MotoController {

  @Autowired
  MotoRepository motoRepository;

  @PostMapping(path = "moto")
  public Moto salvar(@RequestBody Moto moto) {
    return motoRepository.save(moto);
  }

  @GetMapping(path = "moto/{id}")
  public ResponseEntity<Moto> obterPorId(@PathVariable("id") Long id) {
    return motoRepository.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping(path = "moto")
  public List<Moto> listarTodos() {
    return motoRepository.findAll();
  }

  @PutMapping(path = "moto/{id}")
  public ResponseEntity<Moto> atualizar(@PathVariable("id") Long id, @RequestBody Moto motoAtualizada) {
    return motoRepository.findById(id)
        .map(moto -> {
          moto.setMarca(motoAtualizada.getMarca());
          moto.setTipo(motoAtualizada.getTipo());
          moto.setModelo(motoAtualizada.getModelo());
          moto.setTemPartidaEletrica(motoAtualizada.getTemPartidaEletrica());
          return ResponseEntity.ok(motoRepository.save(moto));
        })
        .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping(path = "moto/{id}")
  public ResponseEntity<Void> remover(@PathVariable("id") Long id) {
    if (motoRepository.existsById(id)) {
      motoRepository.deleteById(id);
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }

}
