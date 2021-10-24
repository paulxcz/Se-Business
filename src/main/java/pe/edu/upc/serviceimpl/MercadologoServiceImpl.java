package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Mercadologo;
import pe.edu.upc.repository.IMercadologoRepository;
import pe.edu.upc.serviceinterface.IMercadologoService;
@Service
public class MercadologoServiceImpl implements IMercadologoService {

	@Autowired
	private IMercadologoRepository mR;
	@Override
	public Integer insert(Mercadologo mercadologo) {
		
		int rpta = mR.buscarMercadologo(mercadologo.getNombreMercadologo());
		if (rpta == 0) {
			mR.save(mercadologo);
		}
		return rpta;

	}

	@Override
	public List<Mercadologo> list() {
		// TODO Auto-generated method stub
		return mR.findAll();
	}

}
