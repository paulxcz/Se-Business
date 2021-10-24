package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Contrato;

@Repository
public interface IContratoRepository extends JpaRepository<Contrato, Integer>{

	@Query("select count(c.culminacion) from Contrato c where c.culminacion=:clave")
	public int buscarContrato(@Param("clave")String name);
}
