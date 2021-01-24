package com.deniswillian.uppercomputer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.deniswillian.uppercomputer.domain.Cargo;
import com.deniswillian.uppercomputer.dto.CargoDTO;
import com.deniswillian.uppercomputer.exceptions.ObjectNotFoundException;
import com.deniswillian.uppercomputer.repositories.CargoRepository;

@Service
public class CargoService {

	@Autowired
	private CargoRepository cargoRepository;

	public Cargo find(Integer cd_cargo) {
		Optional<Cargo> obj = cargoRepository.findById(cd_cargo);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + cd_cargo + ", Tipo: " + Cargo.class.getName()));
	}

	public Cargo insert(Cargo obj) {
		obj.setCd_cargo(null);
		return cargoRepository.save(obj);
	}

	public Cargo update(Cargo obj) {
		Cargo newObj = find(obj.getCd_cargo());
		updateData(newObj,obj);
		return cargoRepository.save(newObj);
	}
	
	public void updateData(Cargo newObj, Cargo obj ) {
		newObj.setNm_cargo(obj.getNm_cargo());
	}
	
	
	
	public List<Cargo> findAll() {
		return cargoRepository.findAll();

	}

	public Cargo fromDTO(CargoDTO objDto) {
		return new Cargo(objDto.getCd_cargo(), objDto.getNm_cargo());
	}
}
