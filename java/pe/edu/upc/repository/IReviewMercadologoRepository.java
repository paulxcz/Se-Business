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
	
	
	
	
	@Query(value= "SELECT mer.nombre_mercadologo, mer.rating_mercadologo from mercadologo mer where mer.rating_mercadologo >=4 order by  mer.rating_mercadologo desc",
			nativeQuery=true)
	
	public List<String[]> merXrev();
}
