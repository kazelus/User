package pl.com.oands.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.com.oands.dao.BookDao;
import pl.com.oands.dao.RentDao;
import pl.com.oands.model.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	public void addBook(Book book) {
		bookDao.addBook(book);
	}

	public void updateBook(Book book, int id) {
		bookDao.updateBook(book, id);

	}

	public void deleteBook(int id) {
		bookDao.deleteBook(id);

	}

	public void deleteAllBook() {
		bookDao.deleteAllBook();
	}

	public List<Book> getBook() {
		return bookDao.getBook();
	}

}
