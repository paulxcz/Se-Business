package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entities.Emprendedor;

public interface IEmprendedorService {

	public Integer insert(Emprendedor emprendedor);
	List<Emprendedor> list();
}
