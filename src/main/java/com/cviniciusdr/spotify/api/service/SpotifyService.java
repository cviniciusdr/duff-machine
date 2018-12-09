package com.cviniciusdr.spotify.api.service;

import java.util.List;

import com.wrapper.spotify.model_objects.specification.PlaylistSimplified;
import com.wrapper.spotify.model_objects.specification.PlaylistTrack;

public interface SpotifyService {

	PlaylistSimplified getPlaylistPorEstiloCerveja(String estilo);

	List<PlaylistTrack> getPlaylistTracks(String playlistId);

}
