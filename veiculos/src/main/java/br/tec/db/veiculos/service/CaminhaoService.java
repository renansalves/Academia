
package br.tec.db.veiculos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.tec.db.veiculos.dto.CaminhaoDto;
import br.tec.db.veiculos.model.Caminhao;
import br.tec.db.veiculos.repository.CaminhaoRepository;
import br.tec.db.veiculos.util.ConverterCaminhao;

@Service
public class CaminhaoService {


  @Autowired
  CaminhaoRepository caminhaoRepository;

  @Autowired
  ConverterCaminhao converterCaminhao;

  public CaminhaoDto salvarCaminhao(Caminhao caminhao) {
    return converterCaminhao.converterParaDto(caminhaoRepository.save(caminhao));
  }

  public ResponseEntity<CaminhaoDto> atualizarCaminhao(Caminhao caminhao, Long id) {

    return caminhaoRepository.findById(id).map(caminhaoEntity -> {
      caminhaoEntity.setModelo(caminhao.getModelo());
      caminhaoEntity.setMarca(caminhao.getMarca());
      caminhaoEntity.setTipo(caminhao.getTipo());
      caminhaoEntity.setAnoFabricacao(caminhao.getAnoFabricacao());
      caminhaoEntity.setCapacidadeCarga(caminhao.getCapacidadeCarga());

      Caminhao caminhaoAtualizado = caminhaoRepository.save(caminhaoEntity);
      CaminhaoDto caminhaoDto = converterCaminhao.converterParaDto(caminhaoAtualizado);
      return ResponseEntity.ok(caminhaoDto);
      
    }).orElse(ResponseEntity.notFound().build());

  }

  public ResponseEntity<CaminhaoDto> listaCaminhaoPorId(Long id) {
    return caminhaoRepository.findById(id)
        .map(caminhao -> {
          CaminhaoDto caminhaoDto = converterCaminhao.converterParaDto(caminhao);
          return ResponseEntity.ok(caminhaoDto);
        })
        .orElse(ResponseEntity.notFound().build());
  }

}
