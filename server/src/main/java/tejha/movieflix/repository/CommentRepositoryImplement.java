package tejha.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import tejha.movieflix.entity.CommentEntity;
import tejha.movieflix.entity.MovieEntity;
import tejha.movieflix.entity.User;


@Repository
public class CommentRepositoryImplement implements CommentRepository {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public List<CommentEntity>showAll(){
		TypedQuery<CommentEntity> query = em.createNamedQuery("CommentEntity.showAllComments",CommentEntity.class); 
		return query.getResultList();
	}
	
	@Override
	public List<CommentEntity> showCommentsByMovie(String mid) {
		TypedQuery<CommentEntity> query = em.createNamedQuery("CommentEntity.showCommentsByMovie",CommentEntity.class);
		query.setParameter("mid", mid);
		return query.getResultList();
	}

	@Override
	public CommentEntity createComment(String userId, String movieId, CommentEntity entity) {
		User user = em.find(User.class, userId);
		MovieEntity movieEntity = em.find(MovieEntity.class, movieId);
		entity.setUser(user);
		entity.setMovieEntity(movieEntity);
		em.persist(entity);
		return entity;
	}
	
}
	
	
	
