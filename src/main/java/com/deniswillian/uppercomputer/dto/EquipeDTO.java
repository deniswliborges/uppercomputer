package com.deniswillian.uppercomputer.dto;

import com.deniswillian.uppercomputer.domain.Equipe;

public class EquipeDTO {

	private Integer cd_equipe;

	private String nome;

	public EquipeDTO() {
	}

	public EquipeDTO(Equipe obj) {
		cd_equipe = obj.getCd_equipe();
		nome = obj.getNome();
	}

	public Integer getCd_equipe() {
		return cd_equipe;
	}

	public void setCd_equipe(Integer cd_equipe) {
		this.cd_equipe = cd_equipe;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
