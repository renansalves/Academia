package br.tec.db.veiculos.util;

import org.springframework.stereotype.Component;

import br.tec.db.veiculos.dto.CarroDto;
import br.tec.db.veiculos.model.Carro;

@Component
public class ConverterCarro extends ConverterVeiculo {

  public CarroDto converterParaDto(Carro carro) {

    CarroDto dto = new CarroDto();
    dto.setMarca(carro.getMarca());
    dto.setModelo(carro.getModelo());
    dto.setTipo(carro.getTipo());
    dto.setAnoFabricacao(carro.getAnoFabricacao());
    dto.setNumeroPortas(carro.getNumeroPortas());

    return dto;
  }

  public Carro converterParaEntidade(CarroDto carroDto) {
    Carro carro = new Carro();
    carro.setTipo(carroDto.getTipo());
    carro.setMarca(carroDto.getMarca());
    carro.setModelo(carroDto.getModelo());
    carro.setAnoFabricacao(carroDto.getAnoFabricacao());
    return carro;

  }

};
