package tejha.movieflix.repository;

import java.util.List;
import tejha.movieflix.entity.CommentEntity;

public interface CommentRepository {

	public List<CommentEntity> showAll();
	
	public List<CommentEntity> showCommentsByMovie(String mid);
	
	public CommentEntity createComment(String userId, String movieId, CommentEntity entity);
}
