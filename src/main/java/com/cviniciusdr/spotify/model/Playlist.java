package com.cviniciusdr.spotify.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Playlist {

	@JsonProperty("tracks")
	private List<Musica> musicas;
	
}
