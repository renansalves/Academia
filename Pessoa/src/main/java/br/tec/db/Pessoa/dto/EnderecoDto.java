
package br.tec.db.Pessoa.dto;

import lombok.Data;

@Data
public class EnderecoDto {

  String rua;
  int numero;
  String bairro;
  String cidade;
  String estado;
  String cep;

}
