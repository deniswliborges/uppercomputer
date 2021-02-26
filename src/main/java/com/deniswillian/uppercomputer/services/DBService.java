package com.deniswillian.uppercomputer.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.deniswillian.uppercomputer.domain.Cargo;
import com.deniswillian.uppercomputer.domain.Equipe;
import com.deniswillian.uppercomputer.domain.Ferramenta;
import com.deniswillian.uppercomputer.domain.Funcionario;
import com.deniswillian.uppercomputer.enums.Perfil;
import com.deniswillian.uppercomputer.enums.TipoFuncionario;
import com.deniswillian.uppercomputer.repositories.CargoRepository;
import com.deniswillian.uppercomputer.repositories.EquipeRepository;
import com.deniswillian.uppercomputer.repositories.FerramentaRepository;
import com.deniswillian.uppercomputer.repositories.FuncionarioRepository;

@Service
public class DBService {

	@Autowired
	private BCryptPasswordEncoder pe;
	@Autowired
	private CargoRepository cargoRepository;
	@Autowired
	private EquipeRepository equipeRepository;	
	@Autowired
	private FuncionarioRepository funcionarioRepository;	
	@Autowired
	private FerramentaRepository ferramentaRepository;

	// Criando retorno instantiateTestDatabase(){} para criar o service para criação
	// do banco de dados. Obs: Olhar na class TestConfig
	public void instantiateTestDatabase() {
		Cargo c1 = new Cargo(null, "DEV");
		Cargo c2 = new Cargo(null, "DBA");
		Cargo c3 = new Cargo(null, "BI");
		Cargo c4 = new Cargo(null, "MANAGER PROJECT");
		Cargo c5 = new Cargo(null, "FIELD SERVICE");
		Cargo c6 = new Cargo(null, "SECURITY");
		
		Equipe eq1 = new Equipe(null, "Development");
		Equipe eq2 = new Equipe(null, "Database");
		Equipe eq3 = new Equipe(null, "Management");
		Equipe eq4 = new Equipe(null, "Business Analyst");
		Equipe eq5 = new Equipe(null, "Technical Support");
		Equipe eq6 = new Equipe(null, "Security Information");

		Funcionario f1 = new Funcionario(null, "Denis Willian", "96458754-x", "548657459-41", "denis@gmail.com",
				6500.00, pe.encode("'123"), "Rua Flores", "300", "apto 303 ", " Jardins", "38220834", c1,
				TipoFuncionario.DESENVOLVEDOR,eq1);
		f1.getTelefones().addAll(Arrays.asList("963254456", "56215547"));

		Funcionario f2 = new Funcionario(null, "Michel Gonçalves", "56985471-0", "451230562-47", "Michel@gmail.com",
				10800.00, pe.encode("'123"), "Avenida Matos", "105", "Sala 800", "Centro", "38777012", c2,
				TipoFuncionario.ANAL_BANCO_DADOS,eq2);
		f2.getTelefones().addAll(Arrays.asList("915246600", "45963522"));

		Funcionario f3 = new Funcionario(null, "David Cayuella", "02354209-6", "548625419-12", "david@gmail", 4500.00,
				pe.encode("'123"), "Avenida Floriano", "2106", null, "Vila Andrade", "281777012", c3, TipoFuncionario.ANAL_NEGOCIO,eq3);
		f3.getTelefones().addAll(Arrays.asList("962110455"));

		Funcionario f4 = new Funcionario(null, "Andre Martins", "52145236-8", "478563256-52", "andre@gmail", 7250.00,
				pe.encode("'123"), "Alamenda Tocantins", "26", "casa 3", "Vila Morumbi", "281777012", c4,
				TipoFuncionario.GER_PROJETO,eq4);
		f4.getTelefones().addAll(Arrays.asList("962110455"));
		
		Funcionario f5 = new Funcionario(null, "Wagner Moura", "95563201-x", "632854445-21", "wagner@gmail.com",
				22650.00, pe.encode("'123"), "Rua Djalma", "30", "casa 2 ", " Tatuape", "55845236", c5,
				TipoFuncionario.ANAL_SECURITY,eq6);
		f5.getTelefones().addAll(Arrays.asList("996529963", "55201022"));
		
		Funcionario f6 = new Funcionario(null, "Marco Neri", "32452362-x", "03251452-63", "marco@gmail.com",
				6500.00, pe.encode("'123"), "Alameda Victor Bueno", "04", "apto 4 ", "Bertioga", "33625478", c6,
				TipoFuncionario.FIELD_SERVICE,eq5);
		f6.getTelefones().addAll(Arrays.asList("977854412", "25412365"));
		// Adicionado o colaborador como ADM para realizar CRUDs restritos
		f6.addPerfil(Perfil.ADMIN);

		c1.getFuncionarios().addAll(Arrays.asList(f1));
		c2.getFuncionarios().addAll(Arrays.asList(f2));
		c3.getFuncionarios().addAll(Arrays.asList(f3));
		c4.getFuncionarios().addAll(Arrays.asList(f4));
		c5.getFuncionarios().addAll(Arrays.asList(f6));
		c6.getFuncionarios().addAll(Arrays.asList(f5));
		
		
		cargoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
		

		eq1.getFuncionarios().addAll(Arrays.asList(f1));
		eq2.getFuncionarios().addAll(Arrays.asList(f2));
		eq3.getFuncionarios().addAll(Arrays.asList(f3));
		eq4.getFuncionarios().addAll(Arrays.asList(f4));
		eq5.getFuncionarios().addAll(Arrays.asList(f6));
		eq6.getFuncionarios().addAll(Arrays.asList(f5));
		funcionarioRepository.saveAll(Arrays.asList(f1, f2, f3, f4,f5,f6));
		// FERRAMENTAS GERENTE DE PROJETO(eq3)
		Ferramenta ferr1 = new Ferramenta(null, "Artia", "7.3", eq3);
		Ferramenta ferr2 = new Ferramenta(null, "Slack", "10.3", eq3);
		Ferramenta ferr3 = new Ferramenta(null, "Podio", "2.5", eq3);
		Ferramenta ferr4 = new Ferramenta(null, "Asana", "1.7", eq3);

		// FERRAMENTAS ANALISTA DE NEGÓCIO(eq4)
		Ferramenta ferr5 = new Ferramenta(null, "Conta Azul", "2.1", eq4);
		Ferramenta ferr6 = new Ferramenta(null, "Service Now", "7.1", eq4);
		Ferramenta ferr7 = new Ferramenta(null, "QuickBooks'", "20.9", eq4);
		Ferramenta ferr8 = new Ferramenta(null, "Trello", "2020.13", eq4);

		// FERRAMENTAS ANALISTA BANCO DE DADOS(eq2)
		Ferramenta ferr9 = new Ferramenta(null, "Oracle 11g", "11.2", eq2);
		Ferramenta ferr10 = new Ferramenta(null, "MongoDB", "7.3", eq2);
		Ferramenta ferr11 = new Ferramenta(null, "SQL Server", "7.3", eq2);
		Ferramenta ferr12 = new Ferramenta(null, "PostgreSQL 2012 R2", "9.6", eq2);

		// FERRAMENTAS ANALISTA DE DESENVOLVIMENTO(eq1)
		Ferramenta ferr13 = new Ferramenta(null, "Android Studio", "3.6", eq1);
		Ferramenta ferr14 = new Ferramenta(null, "SpringBoot", "4.2", eq1);
		Ferramenta ferr15 = new Ferramenta(null, "Eclypse", "7.3", eq1);
		Ferramenta ferr16 = new Ferramenta(null, "GitKraken", "7.3", eq1);

		eq1.getFerramentas().addAll(Arrays.asList(ferr13, ferr14, ferr15, ferr16));
		eq2.getFerramentas().addAll(Arrays.asList(ferr9, ferr10, ferr11, ferr12));
		eq3.getFerramentas().addAll(Arrays.asList(ferr1, ferr2, ferr3, ferr4));
		eq4.getFerramentas().addAll(Arrays.asList(ferr5, ferr6, ferr7, ferr8));

		equipeRepository.saveAll(Arrays.asList(eq1, eq2, eq3, eq4, eq5, eq6));

		ferramentaRepository.saveAll(Arrays.asList(ferr1, ferr2, ferr3, ferr4, ferr5, ferr5, ferr6, ferr7, ferr8, ferr9,
				ferr10, ferr11, ferr12, ferr13, ferr14, ferr15, ferr16));

	}

}
