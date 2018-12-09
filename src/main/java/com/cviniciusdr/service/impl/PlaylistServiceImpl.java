package com.cviniciusdr.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cviniciusdr.service.PlaylistService;
import com.cviniciusdr.spotify.api.service.SpotifyService;
import com.cviniciusdr.spotify.model.CervejaPlaylist;
import com.wrapper.spotify.model_objects.specification.PlaylistSimplified;
import com.wrapper.spotify.model_objects.specification.PlaylistTrack;

@Service
public class PlaylistServiceImpl implements PlaylistService{

	
	private final SpotifyService service;

	public PlaylistServiceImpl(SpotifyService service) {
		this.service = service;
	}
	
	@Override
	public CervejaPlaylist getPlaylist(Double temperatura) {
		String estilo = "IPA";

		PlaylistSimplified playlist = service.getPlaylistPorEstiloCerveja(estilo);
		List<PlaylistTrack> playlistTracks = service.getPlaylistTracks(playlist.getId());

		CervejaPlaylist cervejaPlaylist = new CervejaPlaylist().build(estilo, playlist.getName(), playlistTracks);
		
		
		return cervejaPlaylist;
	}
}
