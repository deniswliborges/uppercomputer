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

import com.deniswillian.uppercomputer.domain.Ferramenta;
import com.deniswillian.uppercomputer.dto.FerramentaDTO;
import com.deniswillian.uppercomputer.services.FerramentaService;

@RestController
@RequestMapping(value = "/ferramentas")
public class FerramentaResource {

	@Autowired
	private FerramentaService ferramentaService;

	@RequestMapping(value = "/{cd_ferramenta}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer cd_ferramenta) {
		Ferramenta obj = ferramentaService.find(cd_ferramenta);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody FerramentaDTO objDto) {
		Ferramenta obj = ferramentaService.fromDTO(objDto);
		obj = ferramentaService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cd_ferramenta}")
				.buildAndExpand(obj.getCd_ferramenta()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@RequestMapping(value = "/{cd_ferramenta}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody FerramentaDTO objDto, @PathVariable Integer cd_ferramenta) {
		Ferramenta obj = ferramentaService.fromDTO(objDto);
		obj.setCd_ferramenta(cd_ferramenta);
		obj = ferramentaService.update(obj);
		return ResponseEntity.noContent().build();

	}

	@RequestMapping(value = "/{cd_ferramenta}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer cd_ferramenta) {
		ferramentaService.delete(cd_ferramenta);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<FerramentaDTO>> findAll() {
		List<Ferramenta> list = ferramentaService.findAll();
		List<FerramentaDTO> listDto = list.stream().map(obj -> new FerramentaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	// Paginação Exemplo - /cargos/page?linesPerPage=3&page=1&direction=ASC
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<FerramentaDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Ferramenta> list = ferramentaService.findPage(page, linesPerPage, orderBy, direction);
		Page<FerramentaDTO> listDto = list.map(obj -> new FerramentaDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}

}
