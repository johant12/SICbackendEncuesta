package sic.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sic.model.Encuesta;


@Repository
public interface EncuestaRepository extends JpaRepository<Encuesta, Long>{

}
