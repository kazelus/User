package pl.com.oands;

import javax.sql.DataSource;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@SpringBootApplication
public class Aplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(Aplication.class, args);
	}
	


}
