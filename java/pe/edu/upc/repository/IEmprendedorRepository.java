package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Emprendedor;
@Repository
public interface IEmprendedorRepository extends JpaRepository<Emprendedor, Integer> {

	@Query("select count(e.nombreEmprendedor) from Emprendedor e where e.nombreEmprendedor=:clave")
	public int buscarEmprendedor(@Param("clave")String name);
}
