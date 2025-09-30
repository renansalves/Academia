package br.tec.db.veiculos.model;

public class Moto extends Veiculo {

	public Moto(Veiculo veiculo) {
		super(veiculo.getId(), veiculo.getTipo(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getAnoFabricacao());
	}

	private Boolean temPartidaEletrica;

	public Boolean getTemPartidaEletrica() {
		return temPartidaEletrica;
	}

	public void setTemPartidaEletrica(Boolean temPartidaEletrica) {
		this.temPartidaEletrica = temPartidaEletrica;
	}

}
