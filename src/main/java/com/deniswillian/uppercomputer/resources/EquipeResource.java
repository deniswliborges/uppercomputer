package com.deniswillian.uppercomputer.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deniswillian.uppercomputer.domain.Equipe;
import com.deniswillian.uppercomputer.dto.EquipeDTO;
import com.deniswillian.uppercomputer.services.EquipeService;

@RestController
@RequestMapping(value = "/equipes")
public class EquipeResource {

	private EquipeService equipeService;

	@RequestMapping(value = "/{cd_equipe}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer cd_equipe) {
		Equipe obj = equipeService.find(cd_equipe);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EquipeDTO>> findAll() {
		List<Equipe> list = equipeService.findAll();
		List<EquipeDTO> listDto = list.stream().map(obj -> new EquipeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
