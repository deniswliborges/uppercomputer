package com.deniswillian.uppercomputer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deniswillian.uppercomputer.domain.Cargo;

@Repository
public interface CargoRepository  extends JpaRepository<Cargo, Integer>{

	//@Transactional(readOnly=true)
	//public List<Cargo> findAllByOrderByNome();
}
