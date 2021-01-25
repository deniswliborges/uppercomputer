package com.deniswillian.uppercomputer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.deniswillian.uppercomputer.domain.Funcionario;
import com.deniswillian.uppercomputer.dto.FuncionarioDTO;
import com.deniswillian.uppercomputer.exceptions.ObjectNotFoundException;
import com.deniswillian.uppercomputer.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public Funcionario find(Integer cd_func) {
		Optional<Funcionario>obj = funcionarioRepository.findById(cd_func);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + cd_func + ", Tipo: " + Funcionario.class.getName()));
	}
	
	public Funcionario insert(Funcionario obj ) {
		obj.setCd_func(null);
		return funcionarioRepository.save(obj);
	}
	
	public List<Funcionario>findAll(){
		return funcionarioRepository.findAll();	
		}
	
	

	public Funcionario fromDto(FuncionarioDTO objDto) {
		return new Funcionario(objDto.getCd_func(), objDto.getNome(),objDto.getRg_fun() ,objDto.getCpf_func(),
						objDto.getEmail_func(), objDto.getSalario(),objDto.getSenha(), null);
	}
	
		
}
