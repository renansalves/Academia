package br.tec.db.veiculos.dto;

import io.micrometer.common.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VeiculoDto {

  @NonNull
  private String tipo;
  private String marca;
  private String modelo;
  private Integer anoFabricacao;
}
