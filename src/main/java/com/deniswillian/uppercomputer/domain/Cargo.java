package com.deniswillian.uppercomputer.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Cargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_cargo;

	// @Column(unique=true)
	private String nm_cargo;

	@JsonManagedReference
	@OneToMany(mappedBy = "cargo",cascade=CascadeType.ALL)
	private List<Funcionario> funcionarios = new ArrayList<>();

	public Cargo() {
	}

	public Cargo(Integer cd_cargo, String nm_cargo) {
		super();
		this.cd_cargo = cd_cargo;
		this.nm_cargo = nm_cargo;

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

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cd_cargo == null) ? 0 : cd_cargo.hashCode());
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
		Cargo other = (Cargo) obj;
		if (cd_cargo == null) {
			if (other.cd_cargo != null)
				return false;
		} else if (!cd_cargo.equals(other.cd_cargo))
			return false;
		return true;
	}

}
