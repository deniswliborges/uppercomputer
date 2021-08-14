package com.deniswillian.uppercomputer.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalystRepository extends JpaRepository<Analyst, Long>{

}
