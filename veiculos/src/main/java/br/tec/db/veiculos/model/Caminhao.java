package br.tec.db.veiculos.model;

import com.sun.istack.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "caminhao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Caminhao extends Veiculo {

	@NotNull
	private Integer capacidadeCarga;

}
