package pe.edu.upc.serviceimpl;

import java.util.List;

import pe.edu.upc.entities.Soporte;
import pe.edu.upc.repository.ISoporteRepository;
import pe.edu.upc.serviceinterface.ISoporteService;

public class SoporteServiceImpl implements ISoporteService{

	
	private ISoporteRepository sR;
	@Override
	public Integer insert(Soporte soporte) {
		int rpta = sR.buscarSoporte(soporte.getNombreSoporte());
		if (rpta == 0) {
			sR.save(soporte);
		}
		return rpta;

	}

	@Override
	public List<Soporte> list() {
		// TODO Auto-generated method stub
		return sR.findAll();
	}

}
