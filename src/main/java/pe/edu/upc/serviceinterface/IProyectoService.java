package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entities.Proyecto;

public interface IProyectoService {
	public boolean insert(Proyecto proyecto);
	List<Proyecto> list();
	
	Proyecto listarId(int idProyecto);
}
