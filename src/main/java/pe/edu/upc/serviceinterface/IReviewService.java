package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entities.Review;

public interface IReviewService {

	public Integer insert(Review review);
	List<Review> list();
}
