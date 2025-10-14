package br.tec.db.Pessoa.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.tec.db.Pessoa.model.Pessoa;

/**
 * RepositorioPessoa
 */
public interface RepositorioPessoa extends JpaRepository<Pessoa, Long> {

}
