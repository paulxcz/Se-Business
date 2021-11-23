package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Override
	public Optional<Mercadologo> listarId(int idMercadologo){
		return mR.findById(idMercadologo);
	}

	@Override
	public List<Mercadologo> findByName(String nombreMercadologo) {
		// TODO Auto-generated method stub
		return mR.findByName(nombreMercadologo);
	}
	
	@Override
	public List<Mercadologo> findByNameMercadologoLikeIgnoreCase(String nombreMercadologo) {
		// TODO Auto-generated method stub
		return mR.findByNombreMercadologoIgnoreCase(nombreMercadologo);
	}

	@Override
	@Transactional
	public void delete(int idMercadologo) {
		mR.deleteById(idMercadologo);
	}
	
	
	

	
}
