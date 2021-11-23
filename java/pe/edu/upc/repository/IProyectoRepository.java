package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Proyecto;

@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto, Integer>{

	@Query("select count(p.nombre) from Proyecto p where p.nombre=:name")
	public int buscarProyecto(@Param("name")String nombre);
	
	@Query( value="select empr.nombre_emprendedor, count(id_proyecto) from Proyectos pro JOIN Emprendedor empr on pro.id_emprendedor=empr.id_emprendedor where pro.id_emprendedor = empr.id_emprendedor GROUP BY empr.nombre_emprendedor", nativeQuery = true )
	public List<String[]> proyectosXempre();
}
