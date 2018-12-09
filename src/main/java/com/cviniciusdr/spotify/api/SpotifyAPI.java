package com.cviniciusdr.spotify.api;

import java.util.List;

import com.wrapper.spotify.model_objects.specification.PlaylistSimplified;
import com.wrapper.spotify.model_objects.specification.PlaylistTrack;

public interface SpotifyAPI {

	List<PlaylistSimplified> getPlaylist(String searchParameter);

	List<PlaylistTrack> getPlaylistTracks(String ownerId);
}
