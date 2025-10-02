package br.tec.db.veiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.tec.db.veiculos.model.Veiculo;

/**
 * VeiculosRepository
 */
public interface VeiculosRepository extends JpaRepository<Veiculo, Long> {

}
