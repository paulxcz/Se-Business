package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Mercadologo;
@Repository
public interface IMercadologoRepository extends JpaRepository<Mercadologo, Integer>{

	@Query("select count(m.nombreMercadologo) from Mercadologo m where m.nombreMercadologo=:clave")
	public int buscarMercadologo(@Param("clave")String name);
}
