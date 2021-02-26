package com.deniswillian.uppercomputer.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.deniswillian.uppercomputer.enums.Perfil;
import com.deniswillian.uppercomputer.enums.TipoFuncionario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_func;

	private String nm_func;

	
	private String rg_fun;

	
	private String cpf_func;

	@Column(unique=true)
	private String email_func;

	private double salario;

	@JsonIgnore
	private String senha;
	
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private Integer tipo;
	
	

	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "cd_cargo")
	private Cargo cargo;

	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Equipe_id")
	private Equipe equipe;
	
	
	@ElementCollection
	@CollectionTable(name = "TELEFONE")
	private Set<String> telefones = new HashSet<>();

	
	
	//Configurando para incluir a class Perfil para as permissões de cada Funcionario
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PERFIS")
	private Set<Integer> perfis = new HashSet<>();
	
	
	
	// Todo colaborador tem perfil de cliente e as regras de negócio sobre as permissões de ADM ou Guest é atribuido no DBService 
	public Funcionario() {
		addPerfil(Perfil.CLIENTE);
	}

	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name="endereco_id") private Endereco endereco;
	 */

	public Funcionario(Integer cd_func, String nm_func, String rg_fun, String cpf_func, String email_func,
			double salario, String senha, String logradouro, String numero, String complemento, String bairro, String cep,
			Cargo cargo,TipoFuncionario tipo, Equipe equipe) {
		super();
		this.cd_func = cd_func;
		this.nm_func = nm_func;
		this.rg_fun = rg_fun;
		this.cpf_func = cpf_func;
		this.email_func = email_func;
		this.salario = salario;
		this.senha = senha;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cargo = cargo;
		this.tipo = (tipo == null) ? null : tipo.getCod();
		this.equipe = equipe;
		addPerfil(Perfil.CLIENTE);
		
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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	
	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public TipoFuncionario getTipo() {
		return TipoFuncionario.toEnum(tipo);
	}

	public void setTipo(TipoFuncionario tipo) {
		this.tipo = tipo.getCod();
	}
	
	//Buscando os perfis e convertendo o Integer(1,2,3, etc) para a descrição do código 
	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
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
