package com.cviniciusdr.exception;

public class NotFoundException extends RuntimeException {
	
	public NotFoundException() {
		super("Registro não encontrado");
	}

}
