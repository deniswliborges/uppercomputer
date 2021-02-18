package com.deniswillian.uppercomputer.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.deniswillian.uppercomputer.domain.Equipe;

public class EquipeDTO {

	private Integer cd_equipe;

	@NotEmpty(message = "Preenchimento Obrigatório")
	@Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 80 caracteres")
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
