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

import com.sun.media.jfxmedia.Media;

import pl.com.oands.model.Rent;
import pl.com.oands.service.RentService;



@RestController
public class RentRestControler {
	
	@Autowired
	private RentService rentService;

	@RequestMapping(value = "/rent/{idUser},{idBook}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void addRent(@PathVariable int idUser, @PathVariable int idBook) {
		rentService.addRent(idUser, idBook);
	}
	
	@RequestMapping(value = "/rent/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void deleteRent(@PathVariable int id) {
		rentService.deleteRent(id);
	}
	
	@RequestMapping(value = "/rent/deleteall", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void deleteAllRent(){
		rentService.deleteAllRent();
	}
	
	@RequestMapping(value = "/rents", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Rent> getRents(){
		return rentService.getRents();
	}
	
	@RequestMapping(value = "/rent/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Rent> getSimpleRents(@PathVariable int id){
		return rentService.getSimpleRent(id);
	}
}
