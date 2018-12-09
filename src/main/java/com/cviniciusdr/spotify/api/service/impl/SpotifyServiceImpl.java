package com.cviniciusdr.spotify.api.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cviniciusdr.spotify.api.SpotifyAPI;
import com.cviniciusdr.spotify.api.service.SpotifyService;
import com.cviniciusdr.spotify.exception.NoPlaylistFoundException;
import com.wrapper.spotify.model_objects.specification.PlaylistSimplified;
import com.wrapper.spotify.model_objects.specification.PlaylistTrack;

@Service
public class SpotifyServiceImpl implements SpotifyService {

	private final SpotifyAPI api;

	public SpotifyServiceImpl(SpotifyAPI api) {
		this.api = api;
	}

	@Override
	public PlaylistSimplified getPlaylistPorEstiloCerveja(String estilo) {
		List<PlaylistSimplified> playlist = api.getPlaylist(estilo);
		if (playlist.size() == 0) {
			throw new NoPlaylistFoundException();
		}

		PlaylistSimplified playlistSimplified = playlist.get(0);

		return playlistSimplified;
	}

	@Override
	public List<PlaylistTrack> getPlaylistTracks(String playlistId) {
		return api.getPlaylistTracks(playlistId);
	}

}
