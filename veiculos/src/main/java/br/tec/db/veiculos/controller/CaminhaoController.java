
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

import br.tec.db.veiculos.model.Caminhao;
import br.tec.db.veiculos.repository.CaminhaoRepository;

@RestController
@RequestMapping("veiculos")
public class CaminhaoController {

  @Autowired
  CaminhaoRepository caminhaoRepository;

  @PostMapping(path = "caminhao")
  public Caminhao salvar(@RequestBody Caminhao caminhao) {
    return caminhaoRepository.save(caminhao);
  }

  @GetMapping(path = "caminhao/{id}")
  public ResponseEntity<Caminhao> obterPorId(@PathVariable("id") Long id) {
    return caminhaoRepository.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping(path = "caminhao")
  public List<Caminhao> listarTodos() {
    return caminhaoRepository.findAll();
  }

  @PutMapping(path = "caminhao/{id}")
  public ResponseEntity<Caminhao> atualizar(@PathVariable("id") Long id, @RequestBody Caminhao caminhaoAtualizado) {
    return caminhaoRepository.findById(id)
        .map(caminhao -> {
          caminhao.setMarca(caminhaoAtualizado.getMarca());
          caminhao.setTipo(caminhaoAtualizado.getTipo());
          caminhao.setModelo(caminhaoAtualizado.getModelo());
          caminhao.setCapacidadeCarga(caminhaoAtualizado.getCapacidadeCarga());
          return ResponseEntity.ok(caminhaoRepository.save(caminhao));
        })
        .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping(path = "caminhao/{id}")
  public ResponseEntity<Void> remover(@PathVariable("id") Long id) {
    if (caminhaoRepository.existsById(id)) {
      caminhaoRepository.deleteById(id);
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }

}
