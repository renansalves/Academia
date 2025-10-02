package br.tec.db.veiculos.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MotoDto extends VeiculoDto{
  private Boolean partidaEletrica;
};
