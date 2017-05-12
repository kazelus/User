package pl.com.oands.dao;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import pl.com.oands.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	private DriverManagerDataSource dataSource;
	private NamedParameterJdbcTemplate jdbcTemplate;

	public UserDaoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Bean
	public static DriverManagerDataSource setDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		try (InputStream input = new FileInputStream("config/application.properties")) {

			Properties properties = new Properties();
			properties.load(input);

			dataSource.setUsername(properties.getProperty("datasource.username"));
			dataSource.setPassword(properties.getProperty("datasource.password"));
			dataSource.setUrl(properties.getProperty("datasource.url"));
			dataSource.setDriverClassName(properties.getProperty("datasource.driver"));

			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSource;
	}

	@Override
	public void addUser(User user) {
		dataSource = setDataSource();

		String query = ("INSERT INTO users (name, surname, age, email) VALUES (:name, :surname, :age, :email)");

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", user.getName());
		params.addValue("surname", user.getSurname());
		params.addValue("age", user.getAge());
		params.addValue("email", user.getEmail());

		jdbcTemplate.update(query, params);
	}

	public void editUser(User user, int id) {
		dataSource = setDataSource();

		String query = ("UPDATE users SET name = :name, surname = :surname, age = :age, email = :email WHERE id = :id");

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", user.getName());
		params.addValue("surname", user.getSurname());
		params.addValue("age", user.getAge());
		params.addValue("email", user.getEmail());
		params.addValue("id", id);

		jdbcTemplate.update(query, params);
	}

	public void deleteUser(int id) {
		dataSource = setDataSource();

		String sql = "DELETE FROM users WHERE id = :id";

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);

		jdbcTemplate.update(sql, param);
	}

	public List<User> getUsers() {
		dataSource = setDataSource();

		String sql = "SELECT * FROM users";
		List<User> users = jdbcTemplate.query(sql, new UserRowMaper());

		return users;
	}
}
