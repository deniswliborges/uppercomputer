package com.deniswillian.uppercomputer.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.deniswillian.uppercomputer.domain.Cargo;
import com.deniswillian.uppercomputer.domain.Funcionario;

public class FuncionarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer cd_func;

	@NotEmpty(message = "Preenchimento Obrigatório")
	@Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 80 caracteres")
	private String nm_func;

	@NotEmpty(message = "Preenchimento Obrigatório")
	@Email(message = "Preenchimento Obrigatório")
	private String email_func;
	
	private Cargo cargoId;

	public FuncionarioDTO() {
	}

	public FuncionarioDTO(Funcionario obj) {
		cd_func = obj.getCd_func();
		nm_func = obj.getNm_func();
		email_func = obj.getEmail_func();
		setCargoId(obj.getCargo());

	}

	public Integer getCd_func() {
		return cd_func;
	}

	public void setCd_func(Integer cd_func) {
		this.cd_func = cd_func;
	}

	public String getNm_func() {
		return nm_func;
	}

	public void setNm_func(String nm_func) {
		this.nm_func = nm_func;
	}

	public String getEmail_func() {
		return email_func;
	}

	public void setEmail_func(String email_func) {
		this.email_func = email_func;
	}

	public Cargo getCargoId() {
		return cargoId;
	}

	public void setCargoId(Cargo cargoId) {
		this.cargoId = cargoId;
	}


	

}
