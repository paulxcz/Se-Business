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
	
	
	@Query(value= "SELECT mer.nombre_emprendedor,rvm.calificacion from emprendedor mer join review_emprendedor rvm on mer.id_emprendedor=rvm.id_review where rvm.calificacion=4 or rvm.calificacion=5 order by  rvm.calificacion desc ",
			nativeQuery=true)
	
	public List<String[]> empXrev();
}
