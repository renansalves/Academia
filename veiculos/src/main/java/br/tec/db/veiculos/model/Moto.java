package br.tec.db.veiculos.model;

public class Moto extends Veiculo {

	private Boolean temPartidaEletrica;

	@Override
	public String toString() {
		return "Moto [temPartidaEletrica=" + temPartidaEletrica + ", " + super.toString() + "]";
	}

	public Moto() {
		super(null, null, null, null, null);
	}

	public Moto(Veiculo veiculo) {
		super(veiculo.getId(), veiculo.getTipo(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getAnoFabricacao());
	}

	public Boolean getTemPartidaEletrica() {
		return temPartidaEletrica;
	}

	public void setTemPartidaEletrica(Boolean temPartidaEletrica) {
		this.temPartidaEletrica = temPartidaEletrica;
	}

}
