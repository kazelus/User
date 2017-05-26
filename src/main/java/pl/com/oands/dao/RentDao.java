package pl.com.oands.dao;

import java.util.List;

import pl.com.oands.model.Rent;

public interface RentDao {
	public void addRent(int idUser, int idBook);
	public void deleteRent(int id);
	public void deleteAllRent();
	public List<Rent> getRents();
	public List<Rent> getSimpleRent(int id);
}
