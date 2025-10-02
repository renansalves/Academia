package br.tec.db.veiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.tec.db.veiculos.model.Carro;

/**
 * CarroRepository
 */
public interface CarroRepository extends JpaRepository<Carro, Long> {

}
