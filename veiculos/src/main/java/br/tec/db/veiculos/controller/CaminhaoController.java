
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

import br.tec.db.veiculos.dto.CaminhaoDto;
import br.tec.db.veiculos.model.Caminhao;
import br.tec.db.veiculos.service.CaminhaoService;

@RestController
@RequestMapping("veiculos")
public class CaminhaoController {

  @Autowired
  CaminhaoService caminhaoService;

  @PostMapping(path = "caminhao")
  public CaminhaoDto salvar(@RequestBody Caminhao caminhao) {
    return caminhaoService.salvarCaminhao(caminhao);
  }

  @GetMapping(path = "caminhao/{id}")
  public ResponseEntity<CaminhaoDto> obterPorId(@PathVariable("id") Long id) {
    return caminhaoService.listaCaminhaoPorId(id);
  }

  @PutMapping(path = "caminhao/{id}")
  public ResponseEntity<CaminhaoDto> atualizar(@PathVariable("id") Long id, @RequestBody Caminhao caminhaoAtualizado) {
    return caminhaoService.atualizarCaminhao(caminhaoAtualizado, id);
  }

}
