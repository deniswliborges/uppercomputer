package com.deniswillian.uppercomputer.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.deniswillian.uppercomputer.domain.Cargo;

public class CargoDTO {

	private Integer id;

	@NotEmpty(message = "Prenchimento Obrigatório")
	@Length(min = 3, max = 80, message = "O tamanho deve ser entre 3 a 80 caracteres!")
	private String nome;

	public CargoDTO() {
	}

	public CargoDTO(Cargo obj) {
		id = obj.getCd_cargo();
		nome = obj.getNm_cargo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
