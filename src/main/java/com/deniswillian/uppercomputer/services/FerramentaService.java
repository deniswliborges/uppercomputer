package com.deniswillian.uppercomputer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.deniswillian.uppercomputer.domain.Ferramenta;
import com.deniswillian.uppercomputer.dto.FerramentaDTO;
import com.deniswillian.uppercomputer.exceptions.ObjectNotFoundException;
import com.deniswillian.uppercomputer.repositories.FerramentaRepository;
import com.deniswillian.uppercomputer.services.exceptions.DataIntegrityException;

@Service
public class FerramentaService {
	
	private FerramentaRepository ferramentaRepository;
	
	
	public Ferramenta find(Integer cd_ferramenta) {
		Optional<Ferramenta> obj = ferramentaRepository.findById(cd_ferramenta);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + cd_ferramenta + ", Tipo: " + Ferramenta.class.getName()));
	}

	/*public Ferramenta insert(Ferramenta obj) {
		obj.setCd_ferramenta(null);
		return ferramentaRepository.save(obj);
	}

	public Ferramenta update(Ferramenta obj) {
		Ferramenta newObj = find(obj.getCd_ferramenta());
		updateData(newObj, obj);
		return ferramentaRepository.save(newObj);
	}

	public void updateData(Ferramenta newObj, Ferramenta obj) {
		newObj.setNome(obj.getNome());
	}

	public void delete(Integer cd_ferramenta) {
		find(cd_ferramenta);
		try {
			ferramentaRepository.deleteById(cd_ferramenta);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Ferramenta que possui Funcionarios!");
		}
	}
*/
	public List<Ferramenta> findAll() {
		return ferramentaRepository.findAll();

	}

	/*public Page<Ferramenta> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return ferramentaRepository.findAll(pageRequest);

	}

	public Ferramenta fromDTO(FerramentaDTO objDto) {
		return new Ferramenta(objDto.getCd_ferramenta(), objDto.getNome(),objDto.getVs());
	}
	*/
}
