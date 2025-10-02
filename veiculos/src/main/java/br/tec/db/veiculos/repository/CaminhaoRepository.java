package br.tec.db.veiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.tec.db.veiculos.model.Caminhao;

/**
 * CaminhaoRepository
 */
public interface CaminhaoRepository extends JpaRepository<Caminhao, Long> {

}
