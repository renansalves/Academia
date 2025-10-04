package br.tec.db.veiculos.modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.tec.db.veiculos.model.Caminhao;
import br.tec.db.veiculos.model.Carro;
import br.tec.db.veiculos.model.Moto;
import br.tec.db.veiculos.model.Veiculo;

@SpringBootTest
public class modelTest {

	long id = System.currentTimeMillis();
	String marca;
	String modelo;
	String tipo;
	int anoFabricacao;
	Veiculo veiculo;

	@BeforeEach
	public void init() {
		id = System.currentTimeMillis();
	}

	@Test
	public void criarUmaMoto() {
		marca = "Voltz";
		modelo = "EZ1";
		tipo = "Moto";
		int anoFabricacao = 2023;
		Boolean temPartidaEltrica = true;

		Moto moto = new Moto();
		moto.setTipo(tipo);
		moto.setModelo(modelo);
		moto.setMarca(marca);
		moto.setAnoFabricacao(anoFabricacao);
		moto.setTemPartidaEletrica(temPartidaEltrica);

		assertEquals(moto.getModelo(), modelo);
		assertEquals(moto.getMarca(), marca);
		assertEquals(moto.getTipo(), tipo);
		assertEquals(moto.getAnoFabricacao(), anoFabricacao);
		assertEquals(moto.getTemPartidaEletrica(), temPartidaEltrica);
	}

	@Test
	public void criarUmCaminhao() {
		marca = "Mercedez";
		modelo = "Atego 1719";
		tipo = "Caminhao";
		int anoFabricacao = 2025;
		veiculo = new Veiculo(id, tipo, marca, modelo, anoFabricacao);
		int capacidadeCarga = 1500;

		Caminhao caminhao = new Caminhao();
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
		veiculo = new Veiculo(id, tipo, marca, modelo, anoFabricacao);
		int numeroPortas = 5;

		Carro carro = new Carro();
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
