package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entities.Proyecto;

public interface IProyectoService {

	public Integer insert(Proyecto proyecto);
	List<Proyecto> list();
}
