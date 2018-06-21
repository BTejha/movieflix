package tejha.movieflix.Service;

import tejha.movieflix.entity.RatingEntity;


public interface RatingService {
	
	public RatingEntity createRating(String userId,String movieId,RatingEntity ratingEntity);
	
	
}
