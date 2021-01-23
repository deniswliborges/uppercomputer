package com.deniswillian.uppercomputer.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_func;

	private String nm_func;

	// @Column(unique=true)
	private String rg_fun;

	// @Column(unique=true)
	private String cpf_func;

	// @Column(unique=true)
	private String email_func;

	private double salario;

	private String senha;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "cd_cargo")
	private Cargo cargo;

	@ElementCollection
	@CollectionTable(name = "TELEFONE")
	private Set<String> telefones = new HashSet<>();

	public Funcionario() {
	}

	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name="endereco_id") private Endereco endereco;
	 */

	public Funcionario(Integer cd_func, String nm_func, String rg_fun, String cpf_func, String email_func,
			double salario, String senha, Cargo cargo) {
		super();
		this.cd_func = cd_func;
		this.nm_func = nm_func;
		this.rg_fun = rg_fun;
		this.cpf_func = cpf_func;
		this.email_func = email_func;
		this.salario = salario;
		this.senha = senha;
		this.cargo = cargo;
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

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	/*
	 * public Endereco getEndereco() { return endereco; }
	 * 
	 * public void setEndereco(Endereco endereco) { this.endereco = endereco; }
	 */
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cd_func == null) ? 0 : cd_func.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (cd_func == null) {
			if (other.cd_func != null)
				return false;
		} else if (!cd_func.equals(other.cd_func))
			return false;
		return true;
	}

}
