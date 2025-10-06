package br.tec.db.veiculos.util;

import org.springframework.stereotype.Component;

import br.tec.db.veiculos.dto.CaminhaoDto;
import br.tec.db.veiculos.dto.CarroDto;
import br.tec.db.veiculos.dto.MotoDto;
import br.tec.db.veiculos.dto.VeiculoDto;
import br.tec.db.veiculos.model.Caminhao;
import br.tec.db.veiculos.model.Carro;
import br.tec.db.veiculos.model.Moto;
import br.tec.db.veiculos.model.Veiculo;

@Component
public class VeiculoConverter {

  public VeiculoDto converterParaDto(Veiculo veiculo) {
    if (veiculo instanceof Moto) {
      veiculo.setTipo("Moto");
      Moto moto = (Moto) veiculo;
      MotoDto motoDto = new MotoDto();

      motoDto.setTipo(moto.getTipo());
      motoDto.setMarca(moto.getMarca());
      motoDto.setModelo(moto.getModelo());
      motoDto.setAnoFabricacao(moto.getAnoFabricacao());
      motoDto.setPartidaEletrica(moto.getTemPartidaEletrica());

      return motoDto;
    } else if (veiculo instanceof Carro) {

      veiculo.setTipo("Carro");
      Carro carro = (Carro) veiculo;
      CarroDto carroDto = new CarroDto();

      carroDto.setTipo(carro.getTipo());
      carroDto.setMarca(carro.getMarca());
      carroDto.setModelo(carro.getModelo());
      carroDto.setAnoFabricacao(carro.getAnoFabricacao());
      carroDto.setNumeroPortas(carro.getNumeroPortas());

      return carroDto;
    } else if (veiculo instanceof Caminhao) {
      veiculo.setTipo("Caminhao");
      Caminhao caminhao = (Caminhao) veiculo;
      CaminhaoDto caminhaoDto = new CaminhaoDto();

      caminhaoDto.setTipo(caminhao.getTipo());
      caminhaoDto.setMarca(caminhao.getMarca());
      caminhaoDto.setModelo(caminhao.getModelo());
      caminhaoDto.setAnoFabricacao(caminhao.getAnoFabricacao());
      caminhaoDto.setCapacidadeCarga(caminhao.getCapacidadeCarga());

      return caminhaoDto;
    } else {
      throw new IllegalArgumentException("Tipo de veículo desconhecido");
    }
  }

  public Veiculo converterParaDto(VeiculoDto veiculoDto) {
    if (veiculoDto instanceof MotoDto) {

      MotoDto motoDto = (MotoDto) veiculoDto;
      Moto moto = new Moto();
      moto.setTipo(motoDto.getTipo());
      moto.setMarca(motoDto.getMarca());
      moto.setModelo(motoDto.getModelo());
      moto.setAnoFabricacao(motoDto.getAnoFabricacao());
      moto.setTemPartidaEletrica(motoDto.getPartidaEletrica());

      return moto;
    } else if (veiculoDto instanceof CarroDto) {

      CarroDto carroDto = (CarroDto) veiculoDto;
      Carro carro = new Carro();

      carro.setTipo(carroDto.getTipo());
      carro.setMarca(carroDto.getMarca());
      carro.setModelo(carroDto.getModelo());
      carro.setAnoFabricacao(carroDto.getAnoFabricacao());
      carro.setNumeroPortas(carroDto.getNumeroPortas());

      return carro;
    } else if (veiculoDto instanceof CaminhaoDto) {

      CaminhaoDto caminhaoDto = (CaminhaoDto) veiculoDto;
      Caminhao caminhao = new Caminhao();

      caminhao.setTipo(caminhaoDto.getTipo());
      caminhao.setMarca(caminhaoDto.getMarca());
      caminhao.setModelo(caminhaoDto.getModelo());
      caminhao.setAnoFabricacao(caminhaoDto.getAnoFabricacao());
      caminhao.setCapacidadeCarga(caminhaoDto.getCapacidadeCarga());

      return caminhao;
    } else {
      throw new IllegalArgumentException("Tipo de veículo desconhecido");
    }
  }
}
