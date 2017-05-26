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

@Repository
public class BookDaoLmpl implements BookDao {

	private DriverManagerDataSource dataSource;
	private NamedParameterJdbcTemplate jdbcTemplate;

	public BookDaoLmpl(NamedParameterJdbcTemplate jdbcTemplate) {
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

	public void addBook(Book book) {
		dataSource = setDataSource();
		
		String query = ("INSERT INTO books (bookName, author, year) VALUES (:bookName, :author, :year)");
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("bookName", book.getBookName());
		params.addValue("author", book.getAuthor());
		params.addValue("year", book.getYear());
		
		jdbcTemplate.update(query, params);
	}

	public void updateBook(Book book, int id) {
		dataSource = setDataSource();
		
		String query = "UPDATE books SET bookName = :bookName, author = :author, year = :year WHERE id_book = :id";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("bookName", book.getBookName());
		params.addValue("author", book.getAuthor());
		params.addValue("year", book.getYear());
		params.addValue("id", id);
		
		jdbcTemplate.update(query, params);
	}

	public void deleteBook(int id) {
		dataSource = setDataSource();
		
		String query = "DELETE FROM books WHERE id_book = :id";
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", id);
		
		jdbcTemplate.update(query, param);
	}

	public void deleteAllBook() {
		dataSource = setDataSource();
		
		String query = "DELETE FROM books";
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		jdbcTemplate.update(query, param);	
	}

	public List<Book> getBook() {
		dataSource = setDataSource();
		
		String query = "SELECT * FROM books";
		List<Book> books = jdbcTemplate.query(query, new BookRowMaper());
		
		return books;
	}

}
