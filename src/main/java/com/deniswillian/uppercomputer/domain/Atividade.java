package com.deniswillian.uppercomputer.domain;

import java.io.Serializable;

public class Atividade implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer cd_atividade;
	private String nome;

	public Atividade() {
	}

	public Atividade(Integer cd_atividade, String nome) {
		super();
		this.cd_atividade = cd_atividade;
		this.nome = nome;
	}

	public Integer getCd_atividade() {
		return cd_atividade;
	}

	public void setCd_atividade(Integer cd_atividade) {
		this.cd_atividade = cd_atividade;
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
		result = prime * result + ((cd_atividade == null) ? 0 : cd_atividade.hashCode());
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
		Atividade other = (Atividade) obj;
		if (cd_atividade == null) {
			if (other.cd_atividade != null)
				return false;
		} else if (!cd_atividade.equals(other.cd_atividade))
			return false;
		return true;
	}

}
