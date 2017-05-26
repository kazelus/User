package pl.com.oands.service;

import java.util.List;

import pl.com.oands.model.Book;

public interface BookService {
	
	public void addBook(Book book);
	
	public void updateBook(Book book, int id);
	
	public void deleteBook(int id);
	
	public void deleteAllBook();
	
	public List<Book> getBook();
}
