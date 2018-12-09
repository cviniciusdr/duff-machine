package com.cviniciusdr.spotify.model;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wrapper.spotify.model_objects.specification.ArtistSimplified;
import com.wrapper.spotify.model_objects.specification.PlaylistTrack;
import com.wrapper.spotify.model_objects.specification.Track;

import lombok.Data;

@Data
public class CervejaPlaylist {

	@JsonProperty("beerStyle")
	private String estilo;
	
	private Playlist playlist;

	public CervejaPlaylist build(String estilo, String playlistName, List<PlaylistTrack> playlistTracks) {
		this.estilo = estilo;
		this.playlist = new Playlist();
		this.playlist.setNome(playlistName);
		
		List<Musica> musicas = new ArrayList<>();
		this.playlist.setMusicas(musicas);
		
		playlistTracks.forEach( (p) -> {
			Track track = p.getTrack();
			
			Musica musica = new Musica();
			if(track.getArtists().length > 0) {
				ArtistSimplified artist = track.getArtists()[0];
				musica.setArtista(artist.getName());
				musica.setLink(artist.getExternalUrls().getExternalUrls().get("spotify"));
			}
			
			musica.setNome(track.getName());
			musicas.add(musica);
		});
		
		return this;
	}

	
}
