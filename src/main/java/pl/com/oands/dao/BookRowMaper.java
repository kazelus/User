package pl.com.oands.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pl.com.oands.model.Book;

public class BookRowMaper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int i) throws SQLException {
		
		Book book = new Book();
		
		book.setBookName(rs.getString("bookName"));
		book.setAuthor(rs.getString("author"));
		book.setYear(rs.getInt("year"));
		
		return book;
	}

}

