package br.tec.db.veiculos.model;

public class Carro extends Veiculo {

	private Integer numeroPortas;

	public Carro(Veiculo veiculo) {
		super(veiculo.getId(), veiculo.getTipo(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getAnoFabricacao());
	}

	public Carro() {
		super(null, null, null, null, null);
	}

	public Integer getNumeroPortas() {
		return numeroPortas;
	}

	public void setNumeroPortas(Integer numeroPortas) {
		this.numeroPortas = numeroPortas;
	}

}
