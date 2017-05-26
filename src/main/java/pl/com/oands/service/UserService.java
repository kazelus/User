package pl.com.oands.service;

import java.util.List;

import pl.com.oands.model.User;

public interface UserService {
	public void addUser(User user);

	public void editUser(User user, int id);
		
	public void deleteUser(int id);
	
	public void deleteAllUsers();
	
	public List<User> getUsers();
}
