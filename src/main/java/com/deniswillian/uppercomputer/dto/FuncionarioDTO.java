package com.deniswillian.uppercomputer.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.deniswillian.uppercomputer.domain.Funcionario;

public class FuncionarioDTO {

	
	private Integer cd_func;
	
	@NotEmpty(message = "Preenchimento Obrigatório")
	@Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 80 caracteres")
	private String nome;

	@NotEmpty(message = "Preenchimento Obrigatório")
	@Email(message = "Preenchimento Obrigatório")
	private String email_func;


	public FuncionarioDTO() {
	}

	public FuncionarioDTO(Funcionario obj) {
		cd_func = obj.getCd_func();
		nome = obj.getNm_func();
		email_func = obj.getEmail_func();
	}

	public Integer getCd_func() {
		return cd_func;
	}

	public void setCd_func(Integer cd_func) {
		this.cd_func = cd_func;
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail_func() {
		return email_func;
	}

	public void setEmail_func(String email_func) {
		this.email_func = email_func;
	}
	
	
}
