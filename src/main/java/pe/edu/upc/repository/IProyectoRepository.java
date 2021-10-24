package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.edu.upc.entities.Proyecto;

public interface IProyectoRepository extends JpaRepository<Proyecto, Integer>{

	@Query("select count(p.nombre) from Proyecto p where p.nombre=:clave")
	public int buscarProyecto(@Param("clave")String name);
}
