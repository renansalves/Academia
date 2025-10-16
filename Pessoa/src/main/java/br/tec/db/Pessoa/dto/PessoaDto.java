package br.tec.db.Pessoa.dto;

import java.time.LocalDate;

public record PessoaDto(
    String nome,
    String cpf,
    LocalDate dataNascimento

) {
}
// public class PessoaDto {
//
// String cpf;
// String nome;
// LocalDate dataNascimento;
// List<EnderecoDto> enderecos;
//
// public Boolean validaCpf(String cpf) {
// String pattern = "^\\d+.\\d+.\\d+-\\d+";
//
// return Pattern.matches(pattern, cpf);
//
// }
// }
