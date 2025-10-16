package br.tec.db.Pessoa.modelo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.tec.db.Pessoa.dto.PessoaDto;

/**
 * PessoaMapperInterface
 */
@Mapper
public interface PessoaMapperInterface {

  PessoaMapperInterface INSTANCE = Mappers.getMapper(PessoaMapperInterface.class);

  PessoaDto pessoaDto(Pessoa pessoa);

  @Mapping(target = "id", ignore = true)
  Pessoa pessoa(PessoaDto pessoaDto);
}
