package br.tec.db.Pessoa.dtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.tec.db.Pessoa.dto.PessoaDto;

/**
 * PessoaDtoTest
 */
@ActiveProfiles("test")
@SpringBootTest
public class PessoaDtoTest {

  @Test
  void testaValidacaoDoCpf() {
    String cpf = "123.456.789-00";

    PessoaDto pessoaDto = new PessoaDto();
    Boolean validadorCpf = pessoaDto.validaCpf(cpf);
    assertEquals(true, validadorCpf);
  }

}
