package com.cviniciusdr.exception;

public class BadRequestException extends RuntimeException {

	public BadRequestException() {
		super("Parâmetros inválidos");
	}

}
