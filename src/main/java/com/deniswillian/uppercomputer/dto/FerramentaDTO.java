package com.deniswillian.uppercomputer.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.deniswillian.uppercomputer.domain.Ferramenta;

public class FerramentaDTO {

	
	private Integer cd_ferramenta;
	
	@NotEmpty(message = "Prenchimento Obrigatório")
	@Length(min = 3, max = 80, message = "O tamanho deve ser entre 3 a 80 caracteres!")
	private String nome;
	
	private String vs;
	
	public FerramentaDTO() {
	}
	
	public FerramentaDTO(Ferramenta obj) {
		cd_ferramenta = obj.getCd_ferramenta();
		nome = obj.getNome();
		vs=obj.getVs();
	}

	public Integer getCd_ferramenta() {
		return cd_ferramenta;
	}

	public void setCd_ferramenta(Integer cd_ferramenta) {
		this.cd_ferramenta = cd_ferramenta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getVs() {
		return vs;
	}

	public void setVs(String vs) {
		this.vs = vs;
	}
	

		
}
