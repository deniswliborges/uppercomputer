package com.deniswillian.uppercomputer.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Timer;

public class Projeto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer cd_projeto;
	private String nome;
	private String status;
	private Date dt_real;
	private Date dt_prevista;
	private Timer hr_prevista;
	private Timer hr_real;

	public Projeto() {
	}

	public Projeto(Integer cd_projeto, String nome, String status, Date dt_real, Date dt_prevista, Timer hr_prevista,
			Timer hr_real) {
		super();
		this.cd_projeto = cd_projeto;
		this.nome = nome;
		this.status = status;
		this.dt_real = dt_real;
		this.dt_prevista = dt_prevista;
		this.hr_prevista = hr_prevista;
		this.hr_real = hr_real;
	}

	public Integer getCd_projeto() {
		return cd_projeto;
	}

	public void setCd_projeto(Integer cd_projeto) {
		this.cd_projeto = cd_projeto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDt_real() {
		return dt_real;
	}

	public void setDt_real(Date dt_real) {
		this.dt_real = dt_real;
	}

	public Date getDt_prevista() {
		return dt_prevista;
	}

	public void setDt_prevista(Date dt_prevista) {
		this.dt_prevista = dt_prevista;
	}

	public Timer getHr_prevista() {
		return hr_prevista;
	}

	public void setHr_prevista(Timer hr_prevista) {
		this.hr_prevista = hr_prevista;
	}

	public Timer getHr_real() {
		return hr_real;
	}

	public void setHr_real(Timer hr_real) {
		this.hr_real = hr_real;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cd_projeto == null) ? 0 : cd_projeto.hashCode());
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
		Projeto other = (Projeto) obj;
		if (cd_projeto == null) {
			if (other.cd_projeto != null)
				return false;
		} else if (!cd_projeto.equals(other.cd_projeto))
			return false;
		return true;
	}

}
