package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entities.ReviewEmprendedor;

public interface IReviewEmprendedorService {

	public Integer insert(ReviewEmprendedor review);
	List<ReviewEmprendedor> list();
	
	public List<String[]> empXrev();
}
