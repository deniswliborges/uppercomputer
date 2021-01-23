package com.deniswillian.uppercomputer.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;

	// Class que interage com Classe ResourceException(class que pega erro de acesso
	// do funcionario)

	private Long timeStamp; // Mostrar o momento do erro
	private Integer status; // Atributo para mostrar o erro http
	private String error;
	private String msg; // Mensagem de erro
	private String path;

	// criar apenas os construtores e get/set

	public StandardError(Long timeStamp, Integer status, String error, String msg, String path) {
		super();
		this.timeStamp = timeStamp;
		this.status = status;
		this.error = error;
		this.msg = msg;
		this.path = path;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
