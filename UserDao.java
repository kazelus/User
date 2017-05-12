package pl.com.oands.dao;

import java.util.List;

import pl.com.oands.model.User;

public interface UserDao {
	public void addUser(User user);

	public void editUser(User user, int id);

	public void deleteUser(int id);

	public List<User> getUsers();
}
