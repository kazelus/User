package pl.com.oands.model;

public class Rent {
	
	private int idRent;
	private int idUser;
	private int idBook;
	private String data;
	
	public int getIdRent() {
		return idRent;
	}
	public void setIdRent(int idRent) {
		this.idRent = idRent;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdBook() {
		return idBook;
	}
	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
