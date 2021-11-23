package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.ReviewEmprendedor;

@Repository
public interface IReviewEmprendedorRepository extends JpaRepository<ReviewEmprendedor, Integer>{

	@Query("select count(r.detalleReview) from ReviewEmprendedor r where r.detalleReview=:clave")
	public int buscarReview(@Param("clave")String name);
	
	
	@Query(value= "SELECT emp.nombre_emprendedor, emp.rating_emprendedor from emprendedor emp where emp.rating_emprendedor >=4 order by  emp.rating_emprendedor desc ",
			nativeQuery=true)
	
	public List<String[]> empXrev();
}
