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
	
	
	

	
}
