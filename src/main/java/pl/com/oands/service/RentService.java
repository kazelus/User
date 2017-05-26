package pl.com.oands.service;

import java.util.List;

import pl.com.oands.model.Rent;

public interface RentService {
	
	public void addRent(int idUser, int idBook);
	public void deleteRent(int id);
	public void deleteAllRent();
	public List<Rent> getRents();
	//Po id usera
	public List<Rent> getSimpleRent(int id);
}
