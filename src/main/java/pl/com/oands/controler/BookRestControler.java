package pl.com.oands.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pl.com.oands.model.Book;
import pl.com.oands.service.BookService;

@RestController
public class BookRestControler {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/book", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void addBook(@RequestBody Book book) {
		bookService.addBook(book);
	}

	@RequestMapping(value = "/book/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void updateBook(@RequestBody Book book, @PathVariable int id) {
		bookService.updateBook(book, id);
	}

	@RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void deleteBook(@PathVariable int id) {
		bookService.deleteBook(id);
	}

	@RequestMapping(value = "/book/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void deleteAllBook() {
		bookService.deleteAllBook();
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Book> getBook() {
		return bookService.getBook();
	}
}
