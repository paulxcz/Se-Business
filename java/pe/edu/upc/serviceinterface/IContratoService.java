package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entities.Contrato;

public interface IContratoService {

	public Integer insert(Contrato contrato);
	List<Contrato> list();
}
