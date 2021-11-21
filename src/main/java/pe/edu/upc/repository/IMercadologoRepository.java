package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Mercadologo;
@Repository
public interface IMercadologoRepository extends JpaRepository<Mercadologo, Integer>{

	@Query("select count(m.nombreMercadologo) from Mercadologo m where m.nombreMercadologo=:clave")
	public int buscarMercadologo(@Param("clave")String name);
	
	@Query("select m from Mercadologo m where m.nombreMercadologo like %?1%")
	List<Mercadologo> fetchProductByNameMercadologo(String nombreMercadologo);
	
	@Query("select m from Mercadologo m where m.nombreMercadologo like %?1%")
	public List<Mercadologo> findByName(String nombreMercadologo);
	

	public List<Mercadologo> findByNombreMercadologoIgnoreCase(String nombreMercadologo);
	
	
	@Query(value= "SELECT mer.nombre_mercadologo,rvm.calificacion from mercadologo mer join review_mercadologo rvm on mer.id_mercadologo=rvm.id_review where rvm.calificacion=4 or rvm.calificacion=5 order by  rvm.calificacion desc ",
			nativeQuery=true)
	
	public List<String[]> merXpro();
	

	
}
