package com.cviniciusdr.spotify.exception;

public class NoPlaylistFoundException extends RuntimeException {

	private static final long serialVersionUID = 3989904305614311094L;

	public NoPlaylistFoundException() {
		super("Nenhuma playlist localizada");
	}
}
