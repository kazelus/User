package pl.com.oands.dao;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import pl.com.oands.model.Book;
import pl.com.oands.model.Rent;

@Repository
public class RentDaoImpl implements RentDao {

	private DriverManagerDataSource dataSource;
	private NamedParameterJdbcTemplate jdbcTemplate;

	public RentDaoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
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

	public void addRent(int idUser, int idBook) {
		dataSource = setDataSource();
		
		String query = ("INSERT INTO rent (id_user, id_book) VALUES (:idUser, :idBook)");

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_user", idUser);
		params.addValue("id_book", idBook);
		
		jdbcTemplate.update(query, params);
	}

	public void deleteRent(int id) {
		dataSource = setDataSource();
		
		String query = "DELETE FROM rent WHEAR id_rent = :id";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		
		jdbcTemplate.update(query, params);
	}
	
	public void deleteAllRent(){
		dataSource = setDataSource();
		
		String query = "DELETE FROM rent";
	}

	public List<Rent> getRents() {
		dataSource = setDataSource();
		String query = "SELECT * FROM rent";
		
		List<Rent> rents = jdbcTemplate.query(query, new RentRowMaper());
		
		return rents;
	}

	public List<Rent> getSimpleRent(int id) {
		
		dataSource = setDataSource();
		String query = "SELECT * FROM rent WHERE id_user"+id;
		
		List<Rent> rents = jdbcTemplate.query(query, new RentRowMaper());
		
		return rents;
	}

}
