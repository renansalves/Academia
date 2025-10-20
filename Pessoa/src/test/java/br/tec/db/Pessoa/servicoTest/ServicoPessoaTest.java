package br.tec.db.Pessoa.servicoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.tec.db.Pessoa.Servico.ServicoPessoa;
import br.tec.db.Pessoa.modelo.*;
import br.tec.db.Pessoa.repositorio.RepositorioPessoa;

/**
 * ServicoPessoaTest
 */

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class ServicoPessoaTest {

  @Mock
  private RepositorioPessoa repositorioPessoa;

  @InjectMocks
  private ServicoPessoa servicoPessoa;

  @Test
  @DisplayName("Testa salvar uma pessoa com Endereço")
  void salvarUmaPessoaComEndereco() {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    String dataNasc = "03-06-1989";

    Pessoa pessoa = new Pessoa();
    Endereco endereco = new Endereco();
    String nome = "Renan Alves";
    LocalDate nascimento = LocalDate.parse(dataNasc, formatter);
    String cpf = "123.456.789-00";

    pessoa.setId(1L);
    pessoa.setDataNascimento(nascimento);
    pessoa.setCpf(cpf);
    pessoa.setNome(nome);

    endereco.setId(1L);
    endereco.setEstado("RS");
    endereco.setCidade("Alvorada");
    endereco.setBairro("Algarve");
    endereco.setRua("Zero Hora");
    endereco.setNumero(1481);
    endereco.setCep("94858000");

    List<Endereco> listaEndereco = new ArrayList<Endereco>();
    listaEndereco.add(endereco);
    pessoa.setEnderecos(listaEndereco);

    assertEquals(pessoa.getDataNascimento().toString(), "1989-06-03");
    assertEquals(pessoa.getEnderecos().getFirst(), endereco);
    assertEquals(pessoa.getNome(), "Renan Alves");
    assertEquals(pessoa.getCpf(), "123.456.789-00");

  }
}
