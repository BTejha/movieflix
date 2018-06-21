package tejha.movieflix.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import tejha.movieflix.entity.RatingEntity;
import tejha.movieflix.Exception.ResourceNotInSpecifiedLimit;
import tejha.movieflix.repository.RatingRepository;


public class RatingServiceImplement implements RatingService {

	@Autowired
	private RatingRepository repository;
@Override
@Transactional
public RatingEntity createRating(String userId, String movieId, RatingEntity ratingEntity) {
	double rating = ratingEntity.getRating();
	if (rating<0 || rating>5) {
		throw new ResourceNotInSpecifiedLimit("Rating should be given on a scale of 5");
	}
	return repository.createRating(userId, movieId, ratingEntity);
}
}
