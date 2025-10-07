package br.tec.db.veiculos.dtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.tec.db.veiculos.dto.*;

@ActiveProfiles("test")
@SpringBootTest
public class dtoTest {

	String marca;
	String modelo;
	String tipo;
	int anoFabricacao;
	VeiculoDto veiculo;

	@Test
	public void criarUmaMoto() {
		marca = "Voltz";
		modelo = "EZ1";
		tipo = "Moto";
		int anoFabricacao = 2023;
		Boolean temPartidaEltrica = true;

		MotoDto moto = new MotoDto();
		moto.setTipo(tipo);
		moto.setModelo(modelo);
		moto.setMarca(marca);
		moto.setAnoFabricacao(anoFabricacao);
		moto.setPartidaEletrica(temPartidaEltrica);

		assertEquals(moto.getModelo(), modelo);
		assertEquals(moto.getMarca(), marca);
		assertEquals(moto.getTipo(), tipo);
		assertEquals(moto.getAnoFabricacao(), anoFabricacao);
		assertEquals(moto.getPartidaEletrica(), temPartidaEltrica);
	}

	@Test
	public void criarUmCaminhao() {
		marca = "Mercedez";
		modelo = "Atego 1719";
		tipo = "Caminhao";
		int anoFabricacao = 2025;
		int capacidadeCarga = 1500;

		CaminhaoDto caminhao = new CaminhaoDto();
		caminhao.setTipo(tipo);
		caminhao.setMarca(marca);
		caminhao.setModelo(modelo);
		caminhao.setAnoFabricacao(anoFabricacao);
		caminhao.setCapacidadeCarga(capacidadeCarga);

		assertEquals(caminhao.getModelo(), modelo);
		assertEquals(caminhao.getMarca(), marca);
		assertEquals(caminhao.getTipo(), tipo);
		assertEquals(caminhao.getAnoFabricacao(), anoFabricacao);
		assertEquals(caminhao.getCapacidadeCarga(), capacidadeCarga);
	}

	@Test
	public void criarUmCarro() {
		marca = "BYD";
		modelo = "Dolphin Mini";
		tipo = "Carro";
		int anoFabricacao = 2024;
		int numeroPortas = 5;

		CarroDto carro = new CarroDto();
		carro.setTipo(tipo);
		carro.setMarca(marca);
		carro.setModelo(modelo);
		carro.setAnoFabricacao(anoFabricacao);
		carro.setNumeroPortas(numeroPortas);

		assertEquals(carro.getModelo(), modelo);
		assertEquals(carro.getMarca(), marca);
		assertEquals(carro.getTipo(), tipo);
		assertEquals(carro.getAnoFabricacao(), anoFabricacao);
		assertEquals(carro.getNumeroPortas(), numeroPortas);
	}

}
