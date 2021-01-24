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

import com.deniswillian.uppercomputer.domain.Funcionario;
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
}
