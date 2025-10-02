package br.tec.db.veiculos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class VeiculoDto {

  private String marca;
  private String modelo;
  private String tipo;
  private Integer anoFabricacao;
};
