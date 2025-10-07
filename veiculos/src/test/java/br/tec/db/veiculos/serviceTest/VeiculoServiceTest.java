package br.tec.db.veiculos.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;

import br.tec.db.veiculos.util.VeiculoConverter;
import br.tec.db.veiculos.service.*;
import br.tec.db.veiculos.dto.*;
import br.tec.db.veiculos.model.*;
import br.tec.db.veiculos.repository.*;

@ExtendWith(MockitoExtension.class)
class VeiculoServiceTest {

  @Mock
  private VeiculosRepository veiculosRepository;

  @Mock
  private VeiculoConverter veiculoConverter;

  @InjectMocks
  private VeiculoService veiculoService;

  private Moto moto;
  private VeiculoDto motoDto;

  @BeforeEach
  void setUp() {
    moto = new Moto();
    moto.setId(1L);
    moto.setTipo("Moto");
    moto.setMarca("Honda");
    moto.setModelo("CG 160");
    moto.setAnoFabricacao(2022);
    moto.setTemPartidaEletrica(true);

    motoDto = new VeiculoDto();
    motoDto.setTipo("Moto");
    motoDto.setMarca("Honda");
    motoDto.setModelo("CG 160");
    motoDto.setAnoFabricacao(2022);
  }

  @Test
  void deveListarVeiculos() {
    List<Veiculo> veiculos = List.of(moto);

    when(veiculosRepository.findAll()).thenReturn(veiculos);
    when(veiculoConverter.converterParaDto(moto)).thenReturn(motoDto);

    ResponseEntity<List<VeiculoDto>> resposta = veiculoService.listarVeiculos();

    assertEquals(200, resposta.getStatusCode().value());
    assertEquals(1, resposta.getBody().size());
    assertEquals("Moto", resposta.getBody().get(0).getTipo());
  }

  @Test
  void deveSalvarVeiculo() {
    when(veiculosRepository.save(moto)).thenReturn(moto);
    when(veiculoConverter.converterParaDto(moto)).thenReturn(motoDto);

    VeiculoDto resultado = veiculoService.salvarVeiculo(moto);

    assertNotNull(resultado);
    assertEquals("Honda", resultado.getMarca());
    verify(veiculosRepository).save(moto);
  }

  @Test
  void deveAtualizarVeiculo() {
    Moto novoMoto = new Moto();
    novoMoto.setAnoFabricacao(2023);
    novoMoto.setModelo("CG 160 Fan");
    novoMoto.setMarca("Honda");
    novoMoto.setTipo("Moto");
    novoMoto.setTemPartidaEletrica(false);

    when(veiculosRepository.findById(1L)).thenReturn(Optional.of(moto));
    when(veiculosRepository.save(any(Veiculo.class))).thenReturn(novoMoto);
    when(veiculoConverter.converterParaDto(any(Veiculo.class))).thenReturn(motoDto);

    VeiculoDto atualizado = veiculoService.atualizarVeiculo(novoMoto, 1L);

    assertNotNull(atualizado);
    verify(veiculosRepository).save(any(Veiculo.class));
  }

  @Test
  void deveLancarExcecaoAoAtualizarVeiculoInexistente() {
    when(veiculosRepository.findById(99L)).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> {
      veiculoService.atualizarVeiculo(moto, 99L);
    });
  }

  @Test
  void deveDeletarVeiculoExistente() {
    when(veiculosRepository.existsById(1L)).thenReturn(true);

    Boolean resultado = veiculoService.deletarVeiculo(1L);

    assertTrue(resultado);
    verify(veiculosRepository).deleteById(1L);
  }

  @Test
  void naoDeveDeletarVeiculoInexistente() {
    when(veiculosRepository.existsById(99L)).thenReturn(false);

    Boolean resultado = veiculoService.deletarVeiculo(99L);

    assertFalse(resultado);
    verify(veiculosRepository, never()).deleteById(anyLong());
  }
}
