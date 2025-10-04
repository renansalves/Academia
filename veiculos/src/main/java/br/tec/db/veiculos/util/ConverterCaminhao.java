package br.tec.db.veiculos.util;

import org.springframework.stereotype.Component;

import br.tec.db.veiculos.dto.CaminhaoDto;
import br.tec.db.veiculos.model.Caminhao;

@Component
public class ConverterCaminhao extends ConverterVeiculo {

  public CaminhaoDto converterParaDto(Caminhao caminhao) {

    CaminhaoDto dto = new CaminhaoDto();
    dto.setMarca(caminhao.getMarca());
    dto.setModelo(caminhao.getModelo());
    dto.setTipo(caminhao.getTipo());
    dto.setAnoFabricacao(caminhao.getAnoFabricacao());
    dto.setCapacidadeCarga(caminhao.getCapacidadeCarga());

    return dto;
  }

  public Caminhao converterParaEntidade(CaminhaoDto caminhaoDto) {
    Caminhao entidade = new Caminhao();
    entidade.setTipo(caminhaoDto.getTipo());
    entidade.setMarca(caminhaoDto.getMarca());
    entidade.setModelo(caminhaoDto.getModelo());
    entidade.setAnoFabricacao(caminhaoDto.getAnoFabricacao());
    return entidade;

  }

};
