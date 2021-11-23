package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Soporte;
@Repository
public interface ISoporteRepository extends JpaRepository<Soporte, Integer>{

	@Query("select count(s.nombreSoporte) from Soporte s where s.nombreSoporte=:clave")
	public int buscarSoporte(@Param("clave")String name);
	
	@Query(value="select s.tipo_problema, count(s.tipo_problema) from soporte s group by s.tipo_problema", nativeQuery=true)
	public List<String[]> reporteXtipoProblema();
}
