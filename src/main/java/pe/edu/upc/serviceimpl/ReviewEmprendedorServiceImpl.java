package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Emprendedor;
import pe.edu.upc.entities.ReviewEmprendedor;
import pe.edu.upc.repository.IEmprendedorRepository;
import pe.edu.upc.repository.IReviewEmprendedorRepository;
import pe.edu.upc.serviceinterface.IReviewEmprendedorService;

@Service
public class ReviewEmprendedorServiceImpl implements IReviewEmprendedorService{

	@Autowired
	private IReviewEmprendedorRepository rR;
	
	@Autowired
	private IEmprendedorRepository eR;
	
	
	
	@Override
	public Integer insert(ReviewEmprendedor review) {
		int rpta = rR.buscarReview(review.getDetalleReview());
		if (rpta == 0) {
			rR.save(review);
		}
		
		Emprendedor emprendedor = eR.getById(review.getEmprendedor().getIdEmprendedor());
		float promedio = ((float) review.getCalificacion() + (float) emprendedor.getRatingEmprendedor()) / (float) 2;// promediar la calificación general
																														 
																														
																														
																														
		System.out.println(promedio);
		emprendedor.setRatingEmprendedor(promedio);
		eR.save(emprendedor);	
		return rpta;
	}

	@Override
	public List<ReviewEmprendedor> list() {
		// TODO Auto-generated method stub
		return rR.findAll();
	}
	
	
	@Override
	public List<String[]> empXrev() {
		// TODO Auto-generated method stub
		return rR.empXrev();
	}
	
}
