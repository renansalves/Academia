package br.tec.db.Pessoa.map;

import org.mapstruct.Mapper;

import br.tec.db.Pessoa.dto.PessoaDto;
import br.tec.db.Pessoa.modelo.Pessoa;

/**
 * PessoaMapperInterface
 */
@Mapper(componentModel = "spring", uses = { EnderecoMapperInterface.class })
public interface PessoaMapperInterface {

  PessoaDto toDto(Pessoa pessoa);

  Pessoa toEntity(PessoaDto pessoaDto);

}
