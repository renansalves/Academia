package br.tec.db.veiculos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.tec.db.veiculos.dto.VeiculoDto;
import br.tec.db.veiculos.model.Veiculo;
import br.tec.db.veiculos.repository.VeiculosRepository;
import br.tec.db.veiculos.util.ConverterVeiculo;

public class VeiculoService {

  @Autowired
  private VeiculosRepository veiculosrepository;

  @Autowired
  ConverterVeiculo converterVeiculo;

  public List<VeiculoDto> listarVeiculos() {
    List<Veiculo> listaVeiculos = veiculosrepository.findAll();
    List<VeiculoDto> dtos = new ArrayList<>();

    for (Veiculo veiculo : listaVeiculos) {
      dtos.add(converterVeiculo.converterParaDto(veiculo));
    }

    return dtos;
  }

  public Boolean deletarVeiculo(Long id) {
    if (veiculosrepository.existsById(id)) {
      veiculosrepository.deleteById(id);
      return true;
    }
    return false;
  }

}
