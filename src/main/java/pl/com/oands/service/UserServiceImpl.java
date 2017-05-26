package pl.com.oands.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.com.oands.dao.UserDao;
import pl.com.oands.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public void addUser(User user) {
		userDao.addUser(user);
	}

	public void editUser(User user, int id) {
		userDao.editUser(user, id);
	}

	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}
	
	public void deleteAllUsers(){
		userDao.deleteAllUsers();
	}

	public List<User> getUsers() {
		return userDao.getUsers();
	}

}
