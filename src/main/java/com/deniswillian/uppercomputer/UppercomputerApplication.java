package com.deniswillian.uppercomputer;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;



import org.springframework.stereotype.Service;

import com.deniswillian.uppercomputer.domain.Cargo;
import com.deniswillian.uppercomputer.domain.Endereco;
import com.deniswillian.uppercomputer.domain.Funcionario;
import com.deniswillian.uppercomputer.enums.TipoFuncionario;
import com.deniswillian.uppercomputer.repositories.CargoRepository;
import com.deniswillian.uppercomputer.repositories.FuncionarioRepository;

@SpringBootApplication
public class UppercomputerApplication implements CommandLineRunner {

	//@Autowired
	//private BCryptPasswordEncoder pe;
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private CargoRepository cargoRepository;
	//@Autowired
	//private Endereco enderecoRepository;

	public static void main(String[] args) {

		SpringApplication.run(UppercomputerApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Cargo c1 = new Cargo(null, "DEV");
		Cargo c2 = new Cargo(null, "DBA");
		Cargo c3 = new Cargo(null, "BI");
		Cargo c4 = new Cargo(null, "MANAGER PROJECT");
		Cargo c5 = new Cargo(null, "FIELFD SERVICE");
		Cargo c6 = new Cargo(null, "SECURITY");
		Cargo c7 = new Cargo(null, "SQUAD");
		Cargo c8 = new Cargo(null, "MARKET");

		Funcionario f1 = new Funcionario(null, "Denis Willian", "96458754-x", "548657459-41", "denis@gmail.com",
				6500.00, "123","Rua Flores", "300", "apto 303 ", " Jardins", "38220834",c1, TipoFuncionario.DESENVOLVEDOR);
		f1.getTelefones().addAll(Arrays.asList("963254456", "56215547"));

		Funcionario f2 = new Funcionario(null, "Michel Gonçalves", "56985471-0", "451230562-47", "Michel@gmail.com",
				10800.00, "123", "Avenida Matos", "105", "Sala 800", "Centro", "38777012",c2, TipoFuncionario.ANAL_BANCO_DADOS);
		f2.getTelefones().addAll(Arrays.asList("915246600", "45963522"));

		Funcionario f3 = new Funcionario(null, "David Cayuella", "02354209-6", "548625419-12", "david@gmail", 4500.00,
				"123","Avenida Floriano", "2106", null, "Vila Andrade", "281777012",c3,  TipoFuncionario.ANAL_NEGOCIO);
		f3.getTelefones().addAll(Arrays.asList("962110455"));

		Funcionario f4 = new Funcionario(null, "Andre Martins", "52145236-8", "478563256-52", "andre@gmail", 7250.00,
				"123","Alamenda Tocantins", "26", "casa 3", "Vila Morumbi", "281777012",c4, TipoFuncionario.GER_PROJETO);
		f4.getTelefones().addAll(Arrays.asList("962110455"));

		c1.getFuncionarios().addAll(Arrays.asList(f1));
		c2.getFuncionarios().addAll(Arrays.asList(f2));
		c3.getFuncionarios().addAll(Arrays.asList(f3));
		c4.getFuncionarios().addAll(Arrays.asList(f4));

		cargoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8));
		funcionarioRepository.saveAll(Arrays.asList(f1, f2, f3, f4));

		
	}

}
