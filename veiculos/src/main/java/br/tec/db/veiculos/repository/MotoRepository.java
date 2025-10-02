
package br.tec.db.veiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.tec.db.veiculos.model.Moto;

public interface MotoRepository extends JpaRepository<Moto, Long> {

}
