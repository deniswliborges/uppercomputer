package com.deniswillian.uppercomputer.services.exceptions;

public class PropertyReferenceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PropertyReferenceException(String msg) {
		super(msg);
	}

	public PropertyReferenceException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
