package com.deniswillian.uppercomputer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deniswillian.uppercomputer.domain.Ferramenta;

@Repository
public interface FerramentaRepository extends JpaRepository<Ferramenta, Integer> {

}
