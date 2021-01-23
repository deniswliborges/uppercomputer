package com.deniswillian.uppercomputer.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class IncrementoSalario {

	private double valor;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dt_incremento;

	public IncrementoSalario() {
	}

	public IncrementoSalario(double valor, Date dt_incremento) {
		super();
		this.valor = valor;
		this.dt_incremento = dt_incremento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getDt_incremento() {
		return dt_incremento;
	}

	public void setDt_incremento(Date dt_incremento) {
		this.dt_incremento = dt_incremento;
	}

}
