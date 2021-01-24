package com.deniswillian.uppercomputer.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.deniswillian.uppercomputer.domain.Cargo;
import com.deniswillian.uppercomputer.dto.CargoDTO;
import com.deniswillian.uppercomputer.services.CargoService;

@RestController
@RequestMapping(value = "/cargos")
public class CargoResource {

	@Autowired
	private CargoService cargoService;

	@RequestMapping(value = "/{cd_cargo}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer cd_cargo) {
		Cargo obj = cargoService.find(cd_cargo);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CargoDTO>> findAll() {
		List<Cargo> list = cargoService.findAll();
		List<CargoDTO> listDto = list.stream().map(obj -> new CargoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CargoDTO objDto) {
		Cargo obj = cargoService.fromDTO(objDto);
		obj = cargoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCd_cargo())
				.toUri();
		return ResponseEntity.created(uri).build();

	}
	@RequestMapping(value = "/{cd_cargo}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody CargoDTO objDto, @PathVariable Integer cd_cargo){
		Cargo obj = cargoService.fromDTO(objDto);
		obj.setCd_cargo(cd_cargo);
		obj = cargoService.update(obj);
		return ResponseEntity.noContent().build();
		
	}

}
