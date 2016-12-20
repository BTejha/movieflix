package tejha.movieflix.Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tejha.movieflix.entity.MovieEntity;

@RestController
public class MovieController {

	@PersistenceContext
	private EntityManager em; 
	
	@Transactional
	@RequestMapping(value="/movies", method=RequestMethod.POST)
	public MovieEntity addMovie(@RequestBody MovieEntity entity){
		em.persist(entity);
		return entity;
	}
	
	@RequestMapping(value="/movies", method=RequestMethod.GET)
	public List<MovieEntity> showAllMovies(){
		TypedQuery<MovieEntity> query = em.createQuery("select m from MovieEntity m", MovieEntity.class);
		return query.getResultList();
	}
	
	@Transactional
	@RequestMapping(value="/movies/{id}", method=RequestMethod.PUT)
	public MovieEntity editMovie(@PathVariable("id") String id,@RequestBody MovieEntity entity){
		MovieEntity me = em.find(MovieEntity.class,id);
		em.merge(entity);
		return me;
	}
	
	@RequestMapping(value="/movies/{id}", method=RequestMethod.GET)
	public MovieEntity showOneMovie(@PathVariable("id") String id){
		MovieEntity me = em.find(MovieEntity.class,id);
		return me;
	}	
	
	@Transactional
	@RequestMapping(value="/movies/{id}", method=RequestMethod.DELETE)
	public void deleteMovie(@PathVariable("id") String id){
		MovieEntity me = em.find(MovieEntity.class,id);
		em.remove(me);
	}
}
