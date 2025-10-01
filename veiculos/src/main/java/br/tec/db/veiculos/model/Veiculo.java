package br.tec.db.veiculos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "veiculo")
public class Veiculo {

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "marca")
	private String marca;

	@Column(name = "modelo")
	private String modelo;

	@Column(name = "anoFabricacao")
	private Integer anoFabricacao;

	public Veiculo(Long id, String tipo, String marca, String modelo, Integer anoFabricacao) {
		this.id = id;
		this.tipo = tipo;
		this.marca = marca;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", tipo=" + tipo + ", marca=" + marca + ", modelo=" + modelo + ", anoFabricacao="
				+ anoFabricacao + ", getId()=" + getId() + ", getTipo()=" + getTipo() + ", getMarca()=" + getMarca()
				+ ", getModelo()=" + getModelo() + ", getAnoFabricacao()=" + getAnoFabricacao() + "]";
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

}
