package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.ReviewMercadologo;

@Repository
public interface IReviewMercadologoRepository extends JpaRepository<ReviewMercadologo, Integer>{

	@Query("select count(r.detalleReview) from ReviewMercadologo r where r.detalleReview=:clave")
	public int buscarReview(@Param("clave")String name);
	
	
	@Query(value= "SELECT mer.nombre_mercadologo,rvm.calificacion from mercadologo mer join review_mercadologo rvm on mer.id_mercadologo=rvm.id_review where rvm.calificacion=4 or rvm.calificacion=5 order by  rvm.calificacion desc ",
			nativeQuery=true)
	
	public List<String[]> merXrev();
}
