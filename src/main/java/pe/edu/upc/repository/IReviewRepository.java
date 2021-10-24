package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.edu.upc.entities.Review;

public interface IReviewRepository extends JpaRepository<Review, Integer>{

	@Query("select count(r.detalleReview) from Review r where r.detalleReview=:clave")
	public int buscarReview(@Param("clave")String name);
}
