package br.tec.db.veiculos.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CarroDto extends VeiculoDto {
  private Integer numeroPortas;
};
