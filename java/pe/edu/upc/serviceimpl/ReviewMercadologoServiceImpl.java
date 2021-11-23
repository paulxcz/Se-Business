package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.ReviewMercadologo;
import pe.edu.upc.repository.IReviewMercadologoRepository;
import pe.edu.upc.serviceinterface.IReviewMercadologoService;

@Service
public class ReviewMercadologoServiceImpl implements IReviewMercadologoService{

	@Autowired
	private IReviewMercadologoRepository rR;
	@Override
	public Integer insert(ReviewMercadologo review) {
		int rpta = rR.buscarReview(review.getDetalleReview());
		if (rpta == 0) {
			rR.save(review);
		}
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
