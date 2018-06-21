package tejha.movieflix.repository;

import tejha.movieflix.entity.RatingEntity;

public interface RatingRepository {

	public RatingEntity createRating(String userId,String movieId,RatingEntity ratingEntity);
}
