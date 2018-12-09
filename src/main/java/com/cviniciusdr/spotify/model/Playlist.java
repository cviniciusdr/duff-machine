package com.cviniciusdr.spotify.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Playlist {

	@JsonProperty("name")
	private String nome;
	
	@JsonProperty("name")
	private List<Musica> musicas;
	
}
