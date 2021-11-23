package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entities.ReviewMercadologo;

public interface IReviewMercadologoService {

	public Integer insert(ReviewMercadologo review);
	List<ReviewMercadologo> list();
	
	public List<String[]> merXrev();
}
