package pl.com.oands;

import javax.sql.DataSource;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@SpringBootApplication
public class Aplication {
	
	private Environment env;
	
	public static void main(String[] args) {
		SpringApplication.run(Aplication.class, args);
	}
	
//	public DataSource dataSource(){
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName(env.getRequiredProperty("com.mysql.jdbc.Driver"));
//		dataSource.setUrl(env.getRequiredProperty("jdbc:mysql://localhost:3306/users"));
//		dataSource.setUsername(env.getRequiredProperty("root"));
//		dataSource.setPassword(env.getRequiredProperty("root"));
//		return dataSource();
//	}

}
