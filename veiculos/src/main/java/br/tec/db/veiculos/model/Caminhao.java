package br.tec.db.veiculos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "caminhao")
public class Caminhao extends Veiculo {

	private Integer capacidadeCarga;

	public Caminhao(Veiculo veiculo) {
		super(veiculo.getId(), veiculo.getTipo(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getAnoFabricacao());
	}

	public Caminhao() {
		super(null, null, null, null, null);
	}

	public Integer getCapacidadeCarga() {
		return capacidadeCarga;
	}

	public void setCapacidadeCarga(Integer capacidadeCarga) {
		this.capacidadeCarga = capacidadeCarga;
	}

}
