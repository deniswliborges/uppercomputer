package com.deniswillian.uppercomputer.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.deniswillian.uppercomputer.services.DBService;



@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	public DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
		private String strategy;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		// objeto da class Services instanciado, montado e gerenciado pelo Spring
		dbService.instantiateTestDatabase();		
		return true;
	}
	
	


}
