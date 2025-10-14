package br.tec.db.Pessoa.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

/**
 * PessoaDto
 */

public class PessoaDto {

  String cpf;
  String nome;
  LocalDate dataNascimento;
  List<EnderecoDto> endereco;

  public Boolean validaCpf(String cpf) {
    String pattern = "^\\d+.\\d+.\\d+-\\d+";

    return Pattern.matches(pattern, cpf);

  }
}
