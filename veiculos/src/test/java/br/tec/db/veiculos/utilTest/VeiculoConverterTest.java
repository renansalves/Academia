package br.tec.db.veiculos.utilTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.tec.db.veiculos.model.*;
import br.tec.db.veiculos.dto.*;
import br.tec.db.veiculos.util.VeiculoConverter;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class VeiculoConverterTest {

  private VeiculoConverter veiculoConverter;

  @BeforeEach
  void setup() {
    veiculoConverter = new VeiculoConverter();
  }

  @Test
  void converterMotoParaDto() {
    Moto motoEntidade = new Moto();

    Long id = 1L;
    String modelo = "CG 125";
    String tipo = "Moto";
    String marca = "Honda";
    int anoFabricacao = 2010;
    Boolean partidaEletrica = false;

    motoEntidade.setId(id);
    motoEntidade.setModelo(modelo);
    motoEntidade.setTipo(tipo);
    motoEntidade.setMarca(marca);
    motoEntidade.setAnoFabricacao(anoFabricacao);
    motoEntidade.setTemPartidaEletrica(partidaEletrica);

    VeiculoDto veiculoDto = veiculoConverter.converterParaDto(motoEntidade);

    assertInstanceOf(MotoDto.class, veiculoDto);
    assertEquals(tipo, veiculoDto.getTipo());
    assertEquals(marca, veiculoDto.getMarca());
    assertEquals(modelo, veiculoDto.getModelo());
    assertEquals(anoFabricacao, veiculoDto.getAnoFabricacao());
    assertFalse(((MotoDto) veiculoDto).getPartidaEletrica());

  }

  @Test
  void converterCarroParaDto() {
    Carro carroEntidade = new Carro();

    Long id = 4L;
    String modelo = "Gol";
    String tipo = "Carro";
    String marca = "VW";
    int anoFabricacao = 1999;
    int numeroPortas = 3;

    carroEntidade.setId(id);
    carroEntidade.setModelo(modelo);
    carroEntidade.setTipo(tipo);
    carroEntidade.setMarca(marca);
    carroEntidade.setAnoFabricacao(anoFabricacao);
    carroEntidade.setNumeroPortas(numeroPortas);

    VeiculoDto veiculoDto = veiculoConverter.converterParaDto(carroEntidade);

    assertInstanceOf(CarroDto.class, veiculoDto);
    assertEquals(tipo, veiculoDto.getTipo());
    assertEquals(marca, veiculoDto.getMarca());
    assertEquals(modelo, veiculoDto.getModelo());
    assertEquals(anoFabricacao, veiculoDto.getAnoFabricacao());
    assertEquals(numeroPortas, ((CarroDto) veiculoDto).getNumeroPortas());

  }

  @Test
  void converterCaminhaoParaDto() {
    Caminhao caminhaoEntidade = new Caminhao();

    Long id = 2L;
    String modelo = "FH";
    String tipo = "Caminhao";
    String marca = "Volvo";
    int anoFabricacao = 2020;
    int capacidadeCarga = 18;

    caminhaoEntidade.setId(id);
    caminhaoEntidade.setModelo(modelo);
    caminhaoEntidade.setTipo(tipo);
    caminhaoEntidade.setMarca(marca);
    caminhaoEntidade.setAnoFabricacao(anoFabricacao);
    caminhaoEntidade.setCapacidadeCarga(capacidadeCarga);

    VeiculoDto veiculoDto = veiculoConverter.converterParaDto(caminhaoEntidade);

    assertInstanceOf(CaminhaoDto.class, veiculoDto);
    assertEquals(tipo, veiculoDto.getTipo());
    assertEquals(marca, veiculoDto.getMarca());
    assertEquals(modelo, veiculoDto.getModelo());
    assertEquals(anoFabricacao, veiculoDto.getAnoFabricacao());
    assertEquals(capacidadeCarga, ((CaminhaoDto) veiculoDto).getCapacidadeCarga());

  }

  @Test
  void converterCaminhaoParaEntidade() {
    CaminhaoDto caminhaoDto = new CaminhaoDto();

    String modelo = "Actros";
    String tipo = "Caminhao";
    String marca = "Mercedes-Benz";
    int anoFabricacao = 2022;
    int capacidadeCarga = 25;

    caminhaoDto.setModelo(modelo);
    caminhaoDto.setTipo(tipo);
    caminhaoDto.setMarca(marca);
    caminhaoDto.setAnoFabricacao(anoFabricacao);
    caminhaoDto.setCapacidadeCarga(capacidadeCarga);

    Veiculo veiculoEntidade = veiculoConverter.converterParaEntidade(caminhaoDto);

    assertInstanceOf(Caminhao.class, veiculoEntidade);
    assertEquals(tipo, veiculoEntidade.getTipo());
    assertEquals(marca, veiculoEntidade.getMarca());
    assertEquals(modelo, veiculoEntidade.getModelo());
    assertEquals(anoFabricacao, veiculoEntidade.getAnoFabricacao());
    assertEquals(capacidadeCarga, ((Caminhao) veiculoEntidade).getCapacidadeCarga());

  }

  @Test
  void converterCarroParaEntidade() {
    CarroDto carroDto = new CarroDto();

    String modelo = "Corrola";
    String tipo = "Carro";
    String marca = "Toyota";
    int anoFabricacao = 2021;
    int numeroPortas = 5;

    carroDto.setModelo(modelo);
    carroDto.setTipo(tipo);
    carroDto.setMarca(marca);
    carroDto.setAnoFabricacao(anoFabricacao);
    carroDto.setNumeroPortas(numeroPortas);

    Veiculo veiculoEntidade = veiculoConverter.converterParaEntidade(carroDto);

    assertInstanceOf(Carro.class, veiculoEntidade);
    assertEquals(tipo, veiculoEntidade.getTipo());
    assertEquals(marca, veiculoEntidade.getMarca());
    assertEquals(modelo, veiculoEntidade.getModelo());
    assertEquals(anoFabricacao, veiculoEntidade.getAnoFabricacao());
    assertEquals(numeroPortas, ((Carro) veiculoEntidade).getNumeroPortas());

  }

  @Test
  void converterMotoParaEntidade() {
    MotoDto caminhaoDto = new MotoDto();

    String modelo = "CG 160";
    String tipo = "Moto";
    String marca = "Honda";
    int anoFabricacao = 2022;
    Boolean partidaEletrica = true;

    caminhaoDto.setModelo(modelo);
    caminhaoDto.setTipo(tipo);
    caminhaoDto.setMarca(marca);
    caminhaoDto.setAnoFabricacao(anoFabricacao);
    caminhaoDto.setPartidaEletrica(partidaEletrica);

    Veiculo veiculoEntidade = veiculoConverter.converterParaEntidade(caminhaoDto);

    assertInstanceOf(Moto.class, veiculoEntidade);
    assertEquals(tipo, veiculoEntidade.getTipo());
    assertEquals(marca, veiculoEntidade.getMarca());
    assertEquals(modelo, veiculoEntidade.getModelo());
    assertEquals(anoFabricacao, veiculoEntidade.getAnoFabricacao());
    assertTrue(((Moto) veiculoEntidade).getTemPartidaEletrica());

  }
}
