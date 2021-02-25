package com.deniswillian.uppercomputer.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.deniswillian.uppercomputer.domain.Equipe;
import com.deniswillian.uppercomputer.dto.EquipeDTO;
import com.deniswillian.uppercomputer.services.EquipeService;

@RestController
@RequestMapping(value = "/equipes")
public class EquipeResource {

	@Autowired
	private EquipeService equipeService;

	@RequestMapping(value = "/{cd_equipe}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer cd_equipe) {
		Equipe obj = equipeService.find(cd_equipe);
		return ResponseEntity.ok().body(obj);
	}

	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody EquipeDTO objDto) {
		Equipe obj = equipeService.fromDTO(objDto);
		obj = equipeService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCd_equipe())
				.toUri();
		return ResponseEntity.created(uri).build();

	}

	@RequestMapping(value = "/{cd_equipe}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody EquipeDTO objDto, @PathVariable Integer cd_equipe) {
		Equipe obj = equipeService.fromDTO(objDto);
		obj.setCd_equipe(cd_equipe);
		obj = equipeService.update(obj);
		return ResponseEntity.noContent().build();

	}

	@RequestMapping(value = "/{cd_equipe}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer cd_equipe) {
		equipeService.delete(cd_equipe);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EquipeDTO>> findAll() {
		List<Equipe> list = equipeService.findAll();
		List<EquipeDTO> listDto = list.stream().map(obj -> new EquipeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	// Paginação Exemplo - /cargos/page?linesPerPage=3&page=1&direction=ASC
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<EquipeDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Equipe> list = equipeService.findPage(page, linesPerPage, orderBy, direction);
		Page<EquipeDTO> listDto = list.map(obj -> new EquipeDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
}
