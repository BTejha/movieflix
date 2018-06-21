package tejha.movieflix.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tejha.movieflix.entity.User;
import tejha.movieflix.Exception.ResourceNotFoundException;
import tejha.movieflix.Exception.ResourceNotInSpecifiedLimit;
import tejha.movieflix.repository.UserRepository;


@Service
public class UserServiceImplement implements UserService {

	@Autowired
	private UserRepository repository;
	
	
	@Override
	
	public List<User> showAllUsers(){
	 return repository.showAllUsers();
	
}
	@Override
	public User showOneUser(String uid) {
		User existing = repository.showOneUser(uid);
		if(existing==null){
			throw new ResourceNotFoundException("No User Found");
		}
		return existing;
	}

	@Override
	@Transactional
	public User createUser(User user) {
		if(user.getEmail()==null || user.getPassword()==null)
		{
			throw new ResourceNotInSpecifiedLimit("Please fill all required fields");
		}
		return repository.createUser(user);
	}

	@Override
	@Transactional
	public User updateUser(String uid, User user) {
		User existing = repository.showOneUser(uid);
		if(existing==null){
			throw new ResourceNotFoundException("No User Found");
		}
		return repository.updateUser(user);
	}

	@Override
	@Transactional
	public void deleteUser(String uid) {
		User existing = repository.showOneUser(uid);
		if(existing==null){
			throw new ResourceNotFoundException("No User Found");
		}
		repository.deleteUser(existing);
	}

}

	