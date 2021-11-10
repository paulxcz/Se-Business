package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entities.Emprendedor;
import pe.edu.upc.repository.IEmprendedorRepository;
import pe.edu.upc.serviceinterface.IEmprendedorService;
@Service
public class EmprendedorServiceImpl implements IEmprendedorService{

	@Autowired
	private IEmprendedorRepository eR;
	@Override
	public Integer insert(Emprendedor emprendedor) {
		int rpta = eR.buscarEmprendedor(emprendedor.getNombreEmprendedor());
		if (rpta == 0) {
			eR.save(emprendedor);
		}
		return rpta;

	}

	@Override
	public List<Emprendedor> list() {
		// TODO Auto-generated method stub
		return eR.findAll();
	}
	
	@Override
	@Transactional
	public void delete(int idEmprendedor) {
		eR.deleteById(idEmprendedor);
	}
	
	@Override
	public Optional<Emprendedor> listarId(int idEmprendedor){
		return eR.findById(idEmprendedor);
	}
}
