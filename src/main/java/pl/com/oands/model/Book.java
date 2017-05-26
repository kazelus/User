package pl.com.oands.model;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

public class Book {
	
	private String bookName;
	private String author;
	private int year;
	
	public String getBookName(){
		return bookName;
	}
	
	public void setBookName(String bookName){
		this.bookName = bookName;
	}
	
	public String getAuthor(){
		return author;
	}
	
	public void setAuthor(String author){
		this.author = author;
	}
	
	public int getYear(){
		return year;
	}
	
	public void setYear(int year){
		this.year = year;
	}
}
