package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.ReviewEmprendedor;
import pe.edu.upc.repository.IReviewEmprendedorRepository;
import pe.edu.upc.serviceinterface.IReviewEmprendedorService;

@Service
public class ReviewEmprendedorServiceImpl implements IReviewEmprendedorService{

	@Autowired
	private IReviewEmprendedorRepository rR;
	@Override
	public Integer insert(ReviewEmprendedor review) {
		int rpta = rR.buscarReview(review.getDetalleReview());
		if (rpta == 0) {
			rR.save(review);
		}
		return rpta;
	}

	@Override
	public List<ReviewEmprendedor> list() {
		// TODO Auto-generated method stub
		return rR.findAll();
	}
}
