package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.upc.entities.Review;
import pe.edu.upc.repository.IReviewRepository;
import pe.edu.upc.serviceinterface.IReviewService;

public class ReviewServiceImpl implements IReviewService{

	@Autowired
	private IReviewRepository rR;
	@Override
	public Integer insert(Review review) {
		int rpta = rR.buscarReview(review.getDetalleReview());
		if (rpta == 0) {
			rR.save(review);
		}
		return rpta;

	}

	@Override
	public List<Review> list() {
		// TODO Auto-generated method stub
		return rR.findAll();
	}

}
