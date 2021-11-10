package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entities.Mercadologo;

public interface IMercadologoService {

	public Integer insert(Mercadologo mercadologo);
	
	List<Mercadologo> list();
	
    List<Mercadologo> findByName(String name);
	
	public List<Mercadologo> findByNameMercadologoLikeIgnoreCase(String nombreMercadologo);
}
