package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Contrato;
import pe.edu.upc.repository.IContratoRepository;
import pe.edu.upc.serviceinterface.IContratoService;

@Service
public class ContratoServiceImpl implements IContratoService{

	@Autowired
	private IContratoRepository cR;
	
	@Override
	public Integer insert(Contrato contrato) {
		int rpta = cR.buscarContrato(contrato.getCulminacion());
		if (rpta == 0) {
			cR.save(contrato);
		}
		return rpta;
	}

	@Override
	public List<Contrato> list() {
		// TODO Auto-generated method stub
		return cR.findAll();
	}

}
