package tejha.movieflix.repository;


import java.util.List;

import tejha.movieflix.entity.User;

public interface UserRepository {

public List<User> showAllUsers();
	
	public User showOneUser(String uid);
	
	public User createUser(User user);
	
	public User updateUser(User user);
	
	public void deleteUser(User user);
	
}
