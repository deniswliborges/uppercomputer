package com.deniswillian.uppercomputer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.deniswillian.uppercomputer.domain.Equipe;
import com.deniswillian.uppercomputer.dto.EquipeDTO;
import com.deniswillian.uppercomputer.exceptions.ObjectNotFoundException;
import com.deniswillian.uppercomputer.repositories.EquipeRepository;
import com.deniswillian.uppercomputer.services.exceptions.DataIntegrityException;

@Service
public class EquipeService {

	@Autowired
	private EquipeRepository equipeRepository;
	
	public Equipe find(Integer cd_equipe) {
		Optional<Equipe> obj = equipeRepository.findById(cd_equipe);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! Id:"+ cd_equipe + ", Tipo:" + Equipe.class.getName()));	
	}
	
	public Equipe insert(Equipe obj) {
		obj.setCd_equipe(null);
		return equipeRepository.save(obj);
	}

	public Equipe update(Equipe obj) {
		Equipe newObj = find(obj.getCd_equipe());
		updateData(newObj, obj);
		return equipeRepository.save(newObj);
	}

	public void updateData(Equipe newObj, Equipe obj) {
		newObj.setNome(obj.getNome());
	}

	public void delete(Integer cd_equipe) {
		find(cd_equipe);
		try {
			equipeRepository.deleteById(cd_equipe);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Equipe que possui Funcionarios!");
		}
	}

	public List<Equipe> findAll() {
		return equipeRepository.findAll();

	}
	public Page<Equipe> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return equipeRepository.findAll(pageRequest);

	}

	public Equipe fromDTO(EquipeDTO objDto) {
		return new Equipe(objDto.getCd_equipe(), objDto.getNome());
	}
}
