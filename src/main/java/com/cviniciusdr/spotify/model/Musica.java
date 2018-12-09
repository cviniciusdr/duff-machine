package com.cviniciusdr.spotify.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Musica {
	
	@JsonProperty("name")
	private String nome;

	@JsonProperty("artist")
	private String artista;
	
	@JsonProperty("link")
	private String link;

}
