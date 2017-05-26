package pl.com.oands.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.com.oands.dao.RentDao;
import pl.com.oands.model.Rent;

@Service
public class RentServiceLmpl implements RentService {
	
	@Autowired
	RentDao rentDao;
	
	public void addRent(int idUser, int idBook) {
		rentDao.addRent(idUser, idBook);
	}

	public void deleteRent(int id) {
		rentDao.deleteRent(id);
	}
	
	public void deleteAllRent(){
		rentDao.deleteAllRent();
	}
	
	public List<Rent> getRents(){
		return rentDao.getRents();
	}
	
	public List<Rent> getSimpleRent(int id){
		return rentDao.getSimpleRent(id);
	}
	
}
