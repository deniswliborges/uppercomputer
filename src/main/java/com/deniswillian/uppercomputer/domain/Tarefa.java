package com.deniswillian.uppercomputer.domain;

import java.io.Serializable;

public class Tarefa implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer cd_tarefa;
	private String descrição;

	public Tarefa() {
	}

	public Tarefa(Integer cd_tarefa, String descrição) {
		super();
		this.cd_tarefa = cd_tarefa;
		this.descrição = descrição;
	}

	public Integer getCd_tarefa() {
		return cd_tarefa;
	}

	public void setCd_tarefa(Integer cd_tarefa) {
		this.cd_tarefa = cd_tarefa;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cd_tarefa == null) ? 0 : cd_tarefa.hashCode());
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
		Tarefa other = (Tarefa) obj;
		if (cd_tarefa == null) {
			if (other.cd_tarefa != null)
				return false;
		} else if (!cd_tarefa.equals(other.cd_tarefa))
			return false;
		return true;
	}

}
