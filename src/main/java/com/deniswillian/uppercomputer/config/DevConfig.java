package com.deniswillian.uppercomputer.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.deniswillian.uppercomputer.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {
	@Autowired
	public DBService dbService;

	// Analisando o valor do Hibernate para Atualizar(update), Ignorar ou
	// Criar(create) o Banco de Dados na class Properties-Dev
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	@Bean
	public boolean instantiateDatabase() throws ParseException {

		// Recomendado que no ambiente de Dev não Crie o Banco de Dados porque demora para subir o Sistema
		// Analisando SE objeto "strategy" instanciado do arquivo hibernate.dll do properties-dev NÃO está como CREATE
		// Caso o profile "dev" esteja como CREATE, NÃO instancia o objeto dbService para criar o banco de dados 
		if (!"create".equals(strategy)) {
			return false;
		}

		// objeto da class Services instanciado, montado e gerenciado pelo Spring
		dbService.instantiateTestDatabase();
		return true;
	}
}
