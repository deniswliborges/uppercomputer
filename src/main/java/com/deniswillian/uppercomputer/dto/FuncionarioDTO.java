package com.deniswillian.uppercomputer.dto;

import com.deniswillian.uppercomputer.domain.Cargo;
import com.deniswillian.uppercomputer.domain.Funcionario;

public class FuncionarioDTO {

	private Integer cd_func;

	// @NotEmpty(message = "Preenchimento Obrigatório")
	// @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 80
	// caracteres")
	private String nome;

	private String rg_fun;

	private String cpf_func;

	// @NotEmpty(message = "Preenchimento Obrigatório")
	// @Email(message = "Preenchimento Obrigatório")
	private String email_func;

	private double salario;

	private String senha;

	private Cargo cargo;

	public FuncionarioDTO() {
	}

	public FuncionarioDTO(Funcionario obj) {
		cd_func = obj.getCd_func();
		nome = obj.getNm_func();
		rg_fun = obj.getRg_fun();
		cpf_func = obj.getCpf_func();
		email_func = obj.getEmail_func();
		salario = obj.getSalario();
		senha = obj.getSenha();
		cargo = obj.getCargo();
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

	public String getRg_fun() {
		return rg_fun;
	}

	public void setRg_fun(String rg_fun) {
		this.rg_fun = rg_fun;
	}

	public String getCpf_func() {
		return cpf_func;
	}

	public void setCpf_func(String cpf_func) {
		this.cpf_func = cpf_func;
	}

	public String getEmail_func() {
		return email_func;
	}

	public void setEmail_func(String email_func) {
		this.email_func = email_func;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

}
