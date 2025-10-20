package br.tec.db.Pessoa.map;

import java.time.LocalDate;
import java.time.Period;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import br.tec.db.Pessoa.dto.PessoaDto;
import br.tec.db.Pessoa.modelo.Pessoa;

/**
 * PessoaMapperInterface
 */
@Mapper(componentModel = "spring", uses = { EnderecoMapperInterface.class })
public interface PessoaMapperInterface {

  PessoaDto toDto(Pessoa pessoa);

  Pessoa toEntity(PessoaDto pessoaDto);

  @Named("calcularIdade")
  public static Integer calcularIdade(LocalDate dataNascimento) {
    if (dataNascimento == null) {
      return null; // Retorna nulo se a data de nascimento for nula
    }
    return Period.between(dataNascimento, LocalDate.now()).getYears();
  }
}
