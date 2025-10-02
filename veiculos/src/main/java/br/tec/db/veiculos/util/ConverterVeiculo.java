package br.tec.db.veiculos.util;

import br.tec.db.veiculos.dto.VeiculoDto;
import br.tec.db.veiculos.model.Veiculo;

public class ConverterVeiculo {

  public VeiculoDto converterParaDto(Veiculo veiculo) {
    VeiculoDto Dto = new VeiculoDto() {
    };
    Dto.setTipo(veiculo.getTipo());
    Dto.setMarca(veiculo.getMarca());
    Dto.setModelo(veiculo.getModelo());
    Dto.setAnoFabricacao(veiculo.getAnoFabricacao());
    return Dto;

  }

  public Veiculo converterParaEntidade(VeiculoDto veiculoDto) {
    Veiculo veiculo = new Veiculo();
    veiculo.setTipo(veiculoDto.getTipo());
    veiculo.setMarca(veiculoDto.getMarca());
    veiculo.setModelo(veiculoDto.getModelo());
    veiculo.setAnoFabricacao(veiculoDto.getAnoFabricacao());
    return veiculo;

  }
}
