package tejha.movieflix.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tejha.movieflix.entity.CommentEntity;
import tejha.movieflix.repository.CommentRepository;




@Service
public class CommentServiceImplement implements CommentService {

	
	@Autowired
	private CommentRepository repository;
	
	@Override
	public List<CommentEntity> showAll(){
	return repository.showAll();
	
	
}
	@Override
	public List<CommentEntity> showCommentsByMovie(String mid) {
		
		return repository.showCommentsByMovie(mid);
	}

	
	

	@Transactional
	@Override
	public CommentEntity createComment(String userId, String movieId, CommentEntity entity) {
		return repository.createComment(userId, movieId, entity); 
	}

}








