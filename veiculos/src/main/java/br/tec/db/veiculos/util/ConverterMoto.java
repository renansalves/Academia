package br.tec.db.veiculos.util;

import org.springframework.stereotype.Component;

import br.tec.db.veiculos.dto.MotoDto;
import br.tec.db.veiculos.model.Moto;

@Component
public class ConverterMoto extends ConverterCarro {

  public MotoDto converterParaDto(Moto moto) {

    MotoDto dto = new MotoDto();
    dto.setMarca(moto.getMarca());
    dto.setModelo(moto.getModelo());
    dto.setTipo(moto.getTipo());
    dto.setAnoFabricacao(moto.getAnoFabricacao());
    dto.setPartidaEletrica(moto.getTemPartidaEletrica());

    return dto;
  }

  public Moto converterParaEntidade(MotoDto motoDto) {
    Moto entidade = new Moto();
    entidade.setTipo(motoDto.getTipo());
    entidade.setMarca(motoDto.getMarca());
    entidade.setModelo(motoDto.getModelo());
    entidade.setAnoFabricacao(motoDto.getAnoFabricacao());
    return entidade;

  }

};
