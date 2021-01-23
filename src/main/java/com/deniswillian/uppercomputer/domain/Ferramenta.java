package com.deniswillian.uppercomputer.domain;

import java.io.Serializable;

public class Ferramenta implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer cd_ferramenta;
	private String nome;
	private String vs;

	public Ferramenta() {
	}

	public Ferramenta(Integer cd_ferramenta, String nome, String vs) {
		super();
		this.cd_ferramenta = cd_ferramenta;
		this.nome = nome;
		this.vs = vs;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cd_ferramenta == null) ? 0 : cd_ferramenta.hashCode());
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
		Ferramenta other = (Ferramenta) obj;
		if (cd_ferramenta == null) {
			if (other.cd_ferramenta != null)
				return false;
		} else if (!cd_ferramenta.equals(other.cd_ferramenta))
			return false;
		return true;
	}

}
