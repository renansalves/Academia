package br.tec.db.veiculos.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CaminhaoDto extends VeiculoDto {
  private Integer capacidadeCarga;
};
