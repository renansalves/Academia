package br.tec.db.veiculos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "moto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Moto extends Veiculo {

	@NonNull
	private Boolean temPartidaEletrica;

}
