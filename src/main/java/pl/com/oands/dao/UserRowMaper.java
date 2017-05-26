package pl.com.oands.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pl.com.oands.model.User;

public class UserRowMaper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int i) throws SQLException {
		
		User user = new User();
		
		user.setName(rs.getString("name"));
		user.setSurname(rs.getString("surname"));
		user.setAge(rs.getInt("age"));
		user.setEmail(rs.getString("email"));
		
		return user;
	}
}
