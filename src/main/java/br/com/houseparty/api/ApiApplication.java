package br.com.houseparty.api;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
	
    @Bean
    public DataSource dataSource() {
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    	dataSource.setUrl("jdbc:mysql://localhost:3306/House_Party");
    	dataSource.setUsername("root");
    	dataSource.setPassword("1234");
    	return dataSource;
    }
}
