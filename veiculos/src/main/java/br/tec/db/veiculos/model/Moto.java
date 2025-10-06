package br.tec.db.veiculos.model;

import com.sun.istack.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "moto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Moto extends Veiculo {

	@NotNull
	private Boolean temPartidaEletrica;

}
