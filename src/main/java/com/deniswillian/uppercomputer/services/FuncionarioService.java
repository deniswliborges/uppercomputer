package com.deniswillian.uppercomputer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.deniswillian.uppercomputer.domain.Funcionario;
import com.deniswillian.uppercomputer.exceptions.ObjectNotFoundException;
import com.deniswillian.uppercomputer.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repo;
	
	public Funcionario find(Integer cd_func) {
		Optional<Funcionario>obj = repo.findById(cd_func);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + cd_func + ", Tipo: " + Funcionario.class.getName()));
	}
	
	
	public List<Funcionario>findAll(){
		return repo.findAll();	
		}
	

	
		
}
