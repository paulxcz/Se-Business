package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entities.Soporte;

public interface ISoporteService {

	public Integer insert(Soporte soporte);
	List<Soporte> list();
	
	public List<String[]> reporteXtipoProblema();
}
