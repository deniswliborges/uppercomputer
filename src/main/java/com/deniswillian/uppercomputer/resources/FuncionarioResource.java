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


import com.deniswillian.uppercomputer.domain.Funcionario;
import com.deniswillian.uppercomputer.domain.Funcionario;
import com.deniswillian.uppercomputer.dto.FuncionarioDTO;
import com.deniswillian.uppercomputer.dto.FuncionarioDTO;
import com.deniswillian.uppercomputer.services.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioResource {

	@Autowired
	private FuncionarioService funcionarioService;

	@RequestMapping(value = "/{cd_func}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer cd_func) {
		Funcionario obj = funcionarioService.find(cd_func);
		return ResponseEntity.ok().body(obj);
	}

	/*
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<FuncionarioDTO>> findAll() {
		List<Funcionario> list = funcionarioService.findAll();
		List<FuncionarioDTO> listDto = list.stream().map(obj -> new FuncionarioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void>insert(@Valid @RequestBody FuncionarioDTO objDto){
		Funcionario obj = funcionarioService.fromDto(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cd_func}").buildAndExpand(obj.getCd_func())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	*/
	
	// ==========================================================================================
	
	@RequestMapping(value = "/{cd_func}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody FuncionarioDTO objDto, @PathVariable Integer cd_func) {
		Funcionario obj = funcionarioService.fromDTO(objDto);
		obj.setCd_func(cd_func);
		obj = funcionarioService.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{cd_func}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer cd_func) {
		funcionarioService.delete(cd_func);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<FuncionarioDTO>> findAll() {
		List<Funcionario> list = funcionarioService.findAll();
		List<FuncionarioDTO> listDto = list.stream().map(obj -> new FuncionarioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	// Paginação Exemplo - /cargos/page?linesPerPage=3&page=1&direction=ASC
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<FuncionarioDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Funcionario> list = funcionarioService.findPage(page, linesPerPage, orderBy, direction);
		Page<FuncionarioDTO> listDto = list.map(obj -> new FuncionarioDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
}
