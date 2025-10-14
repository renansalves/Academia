package br.tec.db.Pessoa.Servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.tec.db.Pessoa.model.Pessoa;
import br.tec.db.Pessoa.repositorio.RepositorioPessoa;

/**
 * ServicoPessoa
 */
@Service
public class ServicoPessoa {

  @Autowired
  RepositorioPessoa repositorioPessoa;

  public List<Pessoa> listaPessoa() {
    return repositorioPessoa.findAll();
  }

  public void salvarPessoa(Pessoa pessoa) {
    repositorioPessoa.save(pessoa);
  }

  public Optional<Pessoa> findById(Long id) {
    return repositorioPessoa.findById(id);
  }

  public void deleteById(Long id) {
    repositorioPessoa.deleteById(id);
  }
}
