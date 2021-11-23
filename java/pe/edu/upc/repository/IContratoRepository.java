package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Contrato;

@Repository
public interface IContratoRepository extends JpaRepository<Contrato, Integer>{

	@Query("select count(c.id) from Contrato c where c.id=:clave")
	public int buscarContrato(@Param("clave")int id);
	
	@Query( value="SELECT count( c.id_mercadologo )\"cantidad\", m.nombre_mercadologo from contrato c join mercadologo m on c.id_mercadologo = m.id_mercadologo group by m.nombre_mercadologo order by cantidad desc", nativeQuery = true )
	public List<String[]> mercadologosConMasProyectos();
}
