package com.deniswillian.uppercomputer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.deniswillian.uppercomputer.domain.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{
	
	//@Transactional(readOnly=true)
	//Funcionario findByEmail(String email_func);
	
	

}
