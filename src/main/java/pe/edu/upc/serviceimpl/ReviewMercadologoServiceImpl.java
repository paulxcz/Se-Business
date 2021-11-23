package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Mercadologo;
import pe.edu.upc.entities.ReviewMercadologo;
import pe.edu.upc.repository.IMercadologoRepository;
import pe.edu.upc.repository.IReviewMercadologoRepository;
import pe.edu.upc.serviceinterface.IReviewMercadologoService;

@Service
public class ReviewMercadologoServiceImpl implements IReviewMercadologoService {

	@Autowired
	private IReviewMercadologoRepository rR;

	@Autowired
	private IMercadologoRepository mR;

	@Override
	public Integer insert(ReviewMercadologo review) {
		int rpta = rR.buscarReview(review.getDetalleReview());
		if (rpta == 0) {
			rR.save(review);
		}
		Mercadologo mercadologo = mR.getById(review.getMercadologo().getIdMercadologo());
		float promedio = ((float) review.getCalificacion() + (float) mercadologo.getRatingMercadologo()) / (float) 2;// promediar la calificación general
																														 
																														
																														
																														
		System.out.println(promedio);
		mercadologo.setRatingMercadologo(promedio);
		mR.save(mercadologo);
		return rpta;
	}

	@Override
	public List<ReviewMercadologo> list() {
		// TODO Auto-generated method stub
		return rR.findAll();
	}

	@Override
	public List<String[]> merXrev() {
		// TODO Auto-generated method stub
		return rR.merXrev();
	}
}
