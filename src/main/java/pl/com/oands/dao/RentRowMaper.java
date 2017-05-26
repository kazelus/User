package pl.com.oands.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pl.com.oands.model.Rent;

public class RentRowMaper implements RowMapper<Rent> {
	
	@Override
	public Rent mapRow(ResultSet rs, int i) throws SQLException{
		
		Rent rent = new Rent();
		
		rent.setIdRent(rs.getInt("id_rent"));
		rent.setIdUser(rs.getInt("id_user"));
		rent.setIdBook(rs.getInt("id_book"));
		rent.setData(rs.getString("data"));
		
		return rent;
	}
}
