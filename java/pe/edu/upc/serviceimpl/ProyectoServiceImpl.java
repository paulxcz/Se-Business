package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Proyecto;
import pe.edu.upc.repository.IProyectoRepository;
import pe.edu.upc.serviceinterface.IProyectoService;

@Service
public class ProyectoServiceImpl implements IProyectoService{
	@Autowired
	private IProyectoRepository pR;
	
	@Override
	public boolean insert(Proyecto proyecto) {
		Proyecto objProyecto = pR.save(proyecto);
		if (objProyecto == null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public List<Proyecto> list() {
		// TODO Auto-generated method stub
		return pR.findAll();
	}
	
	@Override
	public Proyecto listarId(int idProyecto){
		Optional<Proyecto> op = pR.findById(idProyecto);
		return op.isPresent() ? op.get() : new Proyecto();
	}	
	
	@Override
	public List<String[]> proyectosXempre(){
		return pR.proyectosXempre();
	}
	
	@Override
	public List<String[]> getCantidadMayor(double pago) {
		return pR.reporteMayorPago(pago);
	}	
	
	@Override
	public List<String[]> getCantidadMenor(double pago) {
		return pR.reporteMenorPago(pago);
	}
}
