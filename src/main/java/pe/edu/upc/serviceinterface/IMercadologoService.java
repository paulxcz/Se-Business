package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entities.Mercadologo;

public interface IMercadologoService {

	public Integer insert(Mercadologo mercadologo);
	
	List<Mercadologo> list();
	
	Optional<Mercadologo> listarId(int idMercadologo);

	List<Mercadologo> findByName(String name);
	
	public void delete(int idMercadologo);
	
	public List<Mercadologo> findByNameMercadologoLikeIgnoreCase(String nombreMercadologo);
	
	
	
	
}
