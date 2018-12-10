package com.cviniciusdr.exception;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3579472794701690416L;

	public NotFoundException() {
		super("Registro não encontrado");
	}

}
