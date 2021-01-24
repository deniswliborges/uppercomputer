package com.deniswillian.uppercomputer.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deniswillian.uppercomputer.domain.Funcionario;
import com.deniswillian.uppercomputer.dto.FuncionarioDTO;
import com.deniswillian.uppercomputer.services.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioResource {

	@Autowired
	private FuncionarioService service;

	@RequestMapping(value = "/{cd_func}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer cd_func) {
		Funcionario obj = service.find(cd_func);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<FuncionarioDTO>> findAll() {
		List<Funcionario> list = service.findAll();
		List<FuncionarioDTO> listDto = list.stream().map(obj -> new FuncionarioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
