package br.tec.db.veiculos.dto;

import lombok.Data;

@Data
public abstract class VeiculoDto {

  private String marca;
  private String modelo;
  private String tipo;
  private Integer anoFabricacao;
};
