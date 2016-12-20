package tejha.movieflix.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tejha.movieflix.entity.MovieEntity;
import tejha.movieflix.entity.RatingEntity;
import tejha.movieflix.entity.User;

@Repository
public class RatingRepositoryImplement implements RatingRepository{

@PersistenceContext

private EntityManager em;

@Override

public RatingEntity createRating(String userId, String movieId, RatingEntity ratingEntity) {
			User userEntity = em.find(User.class, userId);
			MovieEntity movieEntity = em.find(MovieEntity.class, movieId);
			ratingEntity.setUser(userEntity);
			ratingEntity.setMovie(movieEntity);
			em.persist(ratingEntity);
			Query query = em.createNamedQuery("RatingEntity.calculateAverage");
			query.setParameter("mId", movieId);
			double rating = (double) query.getSingleResult();
			double avgRating = Math.round(rating * 10.0) / 10.0;
			
			movieEntity.setImdbRating(avgRating);
			em.merge(movieEntity);
			return ratingEntity;
}


}
