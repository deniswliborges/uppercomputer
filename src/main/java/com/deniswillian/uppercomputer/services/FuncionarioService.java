package com.deniswillian.uppercomputer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.deniswillian.uppercomputer.domain.Cargo;
import com.deniswillian.uppercomputer.domain.Endereco;
import com.deniswillian.uppercomputer.domain.Funcionario;
import com.deniswillian.uppercomputer.dto.CargoDTO;
import com.deniswillian.uppercomputer.dto.FuncionarioDTO;
import com.deniswillian.uppercomputer.dto.FuncionarioNewDTO;
import com.deniswillian.uppercomputer.enums.TipoFuncionario;
import com.deniswillian.uppercomputer.exceptions.ObjectNotFoundException;
import com.deniswillian.uppercomputer.repositories.FuncionarioRepository;
import com.deniswillian.uppercomputer.services.exceptions.DataIntegrityException;

@Service
public class FuncionarioService {

	//@Autowired
	//private BCryptPasswordEncoder pe;
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public Funcionario find(Integer cd_func) {
		Optional<Funcionario> obj = funcionarioRepository.findById(cd_func);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + cd_func + ", Tipo: " + Funcionario.class.getName()));
	}

	public Funcionario insert(Funcionario obj) {
		obj.setCd_func(null);
		return funcionarioRepository.save(obj);
	}

	public Funcionario update(Funcionario obj) {
		Funcionario newObj = find(obj.getCd_func());
		updateData(newObj, obj);
		return funcionarioRepository.save(newObj);
	}

	public void delete(Integer cd_func) {
		find(cd_func);
		try {
			funcionarioRepository.deleteById(cd_func);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Funcionario que possui cargo!");
		}
	}

	public List<Funcionario> findAll() {
		return funcionarioRepository.findAll();

	}

	public Page<Funcionario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return funcionarioRepository.findAll(pageRequest);

	}

	public Funcionario fromDTO(FuncionarioDTO objDto) {
		return new Funcionario(objDto.getCd_func(), objDto.getNm_func(), null, null, objDto.getEmail_func(), 0, null,
				null,null,null,null,null,null,null);
	}

	private void updateData(Funcionario newObj, Funcionario obj) {
		newObj.setNm_func(obj.getNm_func());
		newObj.setEmail_func(obj.getEmail_func());
	}

	public Funcionario fromDTO(FuncionarioNewDTO objDto) {
		Funcionario cli = new Funcionario(null, objDto.getNm_func(), objDto.getRg_fun(),objDto.getCpf_func(),
				objDto.getEmail_func(), objDto.getSalario(), objDto.getSenha(), objDto.getLogradouro(), 
				objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(),
				null,TipoFuncionario.toEnum(objDto.getTipo()));
				
				
				/*(null, objDto.getNm_func(), objDto.getRg_fun(), objDto.getCpf_func(),
				objDto.getEmail_func(), objDto.getSalario(),objDto.getSenha(),objDto.getLogradouro(),objDto.getNumero(),
				objDto.getComplemento(),objDto.getBairro(),objDto.getCep(),objDto.getCargo(),TipoFuncionario.toEnum(objDto.getTipo()));*/

		Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(),
				objDto.getBairro(), objDto.getCep(),cli);

		/*
		 * Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(),
		 * objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), cli, cid);
		 */

		

		cli.getTelefones().add(objDto.getTelefone1());
		if (objDto.getTelefone2() != null) {
			cli.getTelefones().add(objDto.getTelefone2());
		}
		if (objDto.getTelefone3() != null) {
			cli.getTelefones().add(objDto.getTelefone3());
		}
		return cli;
	}

}
