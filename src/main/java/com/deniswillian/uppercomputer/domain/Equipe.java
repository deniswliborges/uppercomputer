package com.deniswillian.uppercomputer.domain;

import java.io.Serializable;

public class Equipe implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer cd_equipe;
	private String nome;

	public Equipe() {
	}

	public Equipe(Integer cd_equipe, String nome) {
		super();
		this.cd_equipe = cd_equipe;
		this.nome = nome;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cd_equipe == null) ? 0 : cd_equipe.hashCode());
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
		Equipe other = (Equipe) obj;
		if (cd_equipe == null) {
			if (other.cd_equipe != null)
				return false;
		} else if (!cd_equipe.equals(other.cd_equipe))
			return false;
		return true;
	}

}
