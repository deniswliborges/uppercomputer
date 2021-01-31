package com.deniswillian.uppercomputer.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deniswillian.uppercomputer.domain.Cargo;
import com.deniswillian.uppercomputer.domain.Ferramenta;
import com.deniswillian.uppercomputer.domain.Funcionario;
import com.deniswillian.uppercomputer.enums.TipoFuncionario;
import com.deniswillian.uppercomputer.repositories.CargoRepository;
import com.deniswillian.uppercomputer.repositories.FerramentaRepository;
import com.deniswillian.uppercomputer.repositories.FuncionarioRepository;

@Service
public class DBService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private CargoRepository cargoRepository;
	@Autowired
	private FerramentaRepository ferramentaRepository;
	
	//Criando retorno instantiateTestDatabase(){} para criar o service para criação do banco de dados. Obs: Olhar na class TestConfig
	public void instantiateTestDatabase() {
		Cargo c1 = new Cargo(null, "DEV");
		Cargo c2 = new Cargo(null, "DBA");
		Cargo c3 = new Cargo(null, "BI");
		Cargo c4 = new Cargo(null, "MANAGER PROJECT");
		Cargo c5 = new Cargo(null, "FIELFD SERVICE");
		Cargo c6 = new Cargo(null, "SECURITY");
		Cargo c7 = new Cargo(null, "SQUAD");
		Cargo c8 = new Cargo(null, "MARKET");
		

		// FERRAMENTAS GERENTE DE PROJETO
		Ferramenta ferr1 = new Ferramenta(null, "Artia", "7.3");
		Ferramenta ferr2 = new Ferramenta(null, "Slack", "10.3");
		Ferramenta ferr3 = new Ferramenta(null, "Podio", "2.5");
		Ferramenta ferr4 = new Ferramenta(null, "Asana", "1.7");

		// FERRAMENTAS ANALISTA DE NEGÓCIO
		Ferramenta ferr5 = new Ferramenta(null, "Conta Azul", "2.1");
		Ferramenta ferr6 = new Ferramenta(null, "Service Now", "7.1");
		Ferramenta ferr7 = new Ferramenta(null, "QuickBooks'", "20.9");
		Ferramenta ferr8 = new Ferramenta(null, "Trello", "2020.13");

		// FERRAMENTAS ANALISTA BANCO DE DADOS
		Ferramenta ferr9 = new Ferramenta(null, "Oracle 11g", "11.2");
		Ferramenta ferr10 = new Ferramenta(null, "MongoDB", "7.3");
		Ferramenta ferr11 = new Ferramenta(null, "SQL Server", "7.3");
		Ferramenta ferr12 = new Ferramenta(null, "PostgreSQL 2012 R2", "9.6");

		// FERRAMENTAS ANALISTA DE DESENVOLVIMENTO
		Ferramenta ferr13 = new Ferramenta(null, "Android Studio", "3.6");
		Ferramenta ferr14 = new Ferramenta(null, "SpringBoot", "4.2");
		Ferramenta ferr15 = new Ferramenta(null, "Eclypse", "7.3");
		Ferramenta ferr16 = new Ferramenta(null, "GitKraken", "7.3");

		Funcionario f1 = new Funcionario(null, "Denis Willian", "96458754-x", "548657459-41", "denis@gmail.com",
				6500.00, "123", "Rua Flores", "300", "apto 303 ", " Jardins", "38220834", c1,
				TipoFuncionario.DESENVOLVEDOR);
		f1.getTelefones().addAll(Arrays.asList("963254456", "56215547"));

		Funcionario f2 = new Funcionario(null, "Michel Gonçalves", "56985471-0", "451230562-47", "Michel@gmail.com",
				10800.00, "123", "Avenida Matos", "105", "Sala 800", "Centro", "38777012", c2,
				TipoFuncionario.ANAL_BANCO_DADOS);
		f2.getTelefones().addAll(Arrays.asList("915246600", "45963522"));

		Funcionario f3 = new Funcionario(null, "David Cayuella", "02354209-6", "548625419-12", "david@gmail", 4500.00,
				"123", "Avenida Floriano", "2106", null, "Vila Andrade", "281777012", c3, TipoFuncionario.ANAL_NEGOCIO);
		f3.getTelefones().addAll(Arrays.asList("962110455"));

		Funcionario f4 = new Funcionario(null, "Andre Martins", "52145236-8", "478563256-52", "andre@gmail", 7250.00,
				"123", "Alamenda Tocantins", "26", "casa 3", "Vila Morumbi", "281777012", c4,
				TipoFuncionario.GER_PROJETO);
		f4.getTelefones().addAll(Arrays.asList("962110455"));

		c1.getFuncionarios().addAll(Arrays.asList(f1));
		c2.getFuncionarios().addAll(Arrays.asList(f2));
		c3.getFuncionarios().addAll(Arrays.asList(f3));
		c4.getFuncionarios().addAll(Arrays.asList(f4));

		cargoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8));
		funcionarioRepository.saveAll(Arrays.asList(f1, f2, f3, f4));

		ferramentaRepository.saveAll(Arrays.asList(ferr1, ferr2, ferr3, ferr4, ferr5, ferr5, ferr6, ferr7, ferr8, ferr9,
				ferr10, ferr11, ferr12, ferr13, ferr14, ferr15, ferr16));	
	}

}
