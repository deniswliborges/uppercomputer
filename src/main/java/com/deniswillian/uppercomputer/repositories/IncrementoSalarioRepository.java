package com.deniswillian.uppercomputer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deniswillian.uppercomputer.domain.IncrementoSalario;

//@Repository
public interface IncrementoSalarioRepository extends JpaRepository<IncrementoSalario, Integer> {

}
