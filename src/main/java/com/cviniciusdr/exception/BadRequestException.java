package com.cviniciusdr.exception;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = -6350405142259978143L;

	public BadRequestException() {
		super("Parâmetros inválidos");
	}

}
