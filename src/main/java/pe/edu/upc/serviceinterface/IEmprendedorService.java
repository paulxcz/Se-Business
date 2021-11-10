package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entities.Emprendedor;

public interface IEmprendedorService {

	public Integer insert(Emprendedor emprendedor);
	
	public void delete(int idEmprendedor);
	
	List<Emprendedor> list();
	
	Optional<Emprendedor> listarId(int idEmprendedor);
}
