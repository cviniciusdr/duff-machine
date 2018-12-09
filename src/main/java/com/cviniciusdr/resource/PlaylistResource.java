package com.cviniciusdr.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cviniciusdr.request.PlaylistRequest;
import com.cviniciusdr.spotify.model.CervejaPlaylist;

@RequestMapping("playlist")
public interface PlaylistResource {
	
	@PostMapping
	ResponseEntity<CervejaPlaylist> getPlaylist(PlaylistRequest request);

}
