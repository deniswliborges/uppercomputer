package com.deniswillian.uppercomputer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deniswillian.uppercomputer.domain.Equipe;
import com.deniswillian.uppercomputer.exceptions.ObjectNotFoundException;
import com.deniswillian.uppercomputer.repositories.EquipeRepository;

@Service
public class EquipeService {

	@Autowired
	private EquipeRepository equipeRepository;
	
	public Equipe find(Integer cd_equipe) {
		Optional<Equipe> obj = equipeRepository.findById(cd_equipe);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! Id:"+ cd_equipe + ", Tipo:" + Equipe.class.getName()));	
	}
	
	public List<Equipe>findAll(){
		return equipeRepository.findAll();
	}
}
