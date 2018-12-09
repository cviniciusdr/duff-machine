package com.cviniciusdr.spotify.api.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cviniciusdr.spotify.api.SpotifyAPI;
import com.cviniciusdr.spotify.exception.SpotifyClientException;
import com.neovisionaries.i18n.CountryCode;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.PlaylistSimplified;
import com.wrapper.spotify.model_objects.specification.PlaylistTrack;
import com.wrapper.spotify.requests.data.playlists.GetPlaylistsTracksRequest;
import com.wrapper.spotify.requests.data.search.simplified.SearchPlaylistsRequest;

@Service
public class SpotifyAPIImpl implements SpotifyAPI {

	private final SpotifyApi api;

	SpotifyAPIImpl(SpotifyApi api) {
		this.api = api;

	}

	@Override
	public List<PlaylistSimplified> getPlaylist(String searchParameter) {
		SearchPlaylistsRequest request = createPlaylistRequest(searchParameter);
		try {
			Paging<PlaylistSimplified> pagingPlaylists = request.execute();
			List<PlaylistSimplified> playlist = Arrays.stream(pagingPlaylists.getItems()).collect(Collectors.toList());

			return playlist;
		} catch (Exception e) {
			throw new SpotifyClientException();
		}
	}

	private SearchPlaylistsRequest createPlaylistRequest(String searchParameter) {
		SearchPlaylistsRequest searchPlaylistsRequest = api.searchPlaylists(searchParameter)//
				.market(CountryCode.BR)//
				.limit(10)//
				.offset(0)//
				.build();

		return searchPlaylistsRequest;
	}

	@Override
	public List<PlaylistTrack> getPlaylistTracks(String playlistId) {
		GetPlaylistsTracksRequest request = createPlaylistTracksRequest(playlistId);
		try {
			Paging<PlaylistTrack> execute = request.execute();
			List<PlaylistTrack> tracks = Arrays.stream(execute.getItems()).collect(Collectors.toList());
			return tracks;
		} catch (IOException | SpotifyWebApiException e) {
			throw new SpotifyClientException("Erro ao buscar as musicas da playlist");
		} 
	}

	private GetPlaylistsTracksRequest createPlaylistTracksRequest(String playlistId) {
		GetPlaylistsTracksRequest getPlaylistsTracksRequest = api.getPlaylistsTracks(playlistId)//
				.market(CountryCode.BR)//
				.build();

		return getPlaylistsTracksRequest;
	}

}
