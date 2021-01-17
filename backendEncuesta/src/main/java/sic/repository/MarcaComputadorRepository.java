package sic.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sic.model.MarcaComputador;

@Repository
public interface MarcaComputadorRepository extends JpaRepository<MarcaComputador, Long>{

}
