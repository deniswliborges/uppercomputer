package com.deniswillian.uppercomputer.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.deniswillian.uppercomputer.domain.Cargo;

public class CargoDTO {

	private Integer cd_cargo;

	@NotEmpty(message = "Prenchimento Obrigatório")
	@Length(min = 3, max = 80, message = "O tamanho deve ser entre 3 a 80 caracteres!")
	private String nm_cargo;

	public CargoDTO() {
	}

	public CargoDTO(Cargo obj) {
		cd_cargo = obj.getCd_cargo();
		nm_cargo = obj.getNm_cargo();
	}

	public Integer getCd_cargo() {
		return cd_cargo;
	}

	public void setCd_cargo(Integer cd_cargo) {
		this.cd_cargo = cd_cargo;
	}

	public String getNm_cargo() {
		return nm_cargo;
	}

	public void setNm_cargo(String nm_cargo) {
		this.nm_cargo = nm_cargo;
	}

}
