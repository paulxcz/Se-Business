package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.ReviewEmprendedor;

@Repository
public interface IReviewEmprendedorRepository extends JpaRepository<ReviewEmprendedor, Integer>{

	@Query("select count(r.detalleReview) from ReviewEmprendedor r where r.detalleReview=:clave")
	public int buscarReview(@Param("clave")String name);
}
