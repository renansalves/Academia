package br.tec.db.veiculos.modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.tec.db.veiculos.model.Moto;

@SpringBootTest
public class modelTest {

	@Test
	public void criarUmaMoto() {

		long id = System.currentTimeMillis();
		String marca = "Voltz";
		String modelo = "EZ1";
		String tipo = "Moto";
		int anoFabricacao = 2023;
		Boolean temPartidaEltrica = true;
		Moto moto = new Moto();
		moto.setId(id);
		moto.setTipo(tipo);
		moto.setMarca(marca);
		moto.setModelo(modelo);
		moto.setAnoFabricacao(anoFabricacao);
		moto.setTemPartidaEletrica(temPartidaEltrica);

		assertEquals(moto.getModelo(), modelo);
		assertEquals(moto.getMarca(), marca);
		assertEquals(moto.getTipo(), tipo);
		assertEquals(moto.getAnoFabricacao(), anoFabricacao);
		assertEquals(moto.getTemPartidaEletrica(), temPartidaEltrica);
	}
}
