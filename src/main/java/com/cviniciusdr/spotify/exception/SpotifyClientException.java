package com.cviniciusdr.spotify.exception;

public class SpotifyClientException extends RuntimeException {

	private static final long serialVersionUID = -4413876815836670710L;

	public SpotifyClientException() {
		super("Erro ao consumir a API do Spotify");
	}

	public SpotifyClientException(String erro) {
		super(erro);
	}
}
