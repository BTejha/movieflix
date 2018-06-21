package tejha.movieflix.Service;

import java.util.List;

import tejha.movieflix.entity.User;


public interface UserService {
	
	public List<User> showAllUsers();
	
	public User showOneUser(String uid);
	
	public User createUser(User user);
	
	public User updateUser(String uid, User user);
	
	public void deleteUser(String uid);
	
}
