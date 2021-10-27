package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.upc.entities.Proyecto;
import pe.edu.upc.repository.IProyectoRepository;
import pe.edu.upc.serviceinterface.IProyectoService;

public class ProyectoServiceImpl implements IProyectoService{

	@Autowired
	private IProyectoRepository pR;
	
	@Override
	public Integer insert(Proyecto proyecto) {
		int rpta = pR.buscarProyecto(proyecto.getNombre());
		if (rpta == 0) {
			pR.save(proyecto);
		}
		return rpta;

	}

	@Override
	public List<Proyecto> list() {
		// TODO Auto-generated method stub
		return pR.findAll();
	}

}
