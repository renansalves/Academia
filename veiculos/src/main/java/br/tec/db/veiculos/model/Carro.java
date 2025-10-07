package br.tec.db.veiculos.model;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "carro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Carro extends Veiculo {

	@NonNull
	private Integer numeroPortas;

}
