package com.cviniciusdr.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cviniciusdr.request.PlaylistRequest;
import com.cviniciusdr.service.PlaylistService;
import com.cviniciusdr.spotify.model.CervejaPlaylist;

@RestController
public class PlaylistController implements PlaylistResource {

	@Autowired
	private PlaylistService service;
	
	@Override
	public ResponseEntity<CervejaPlaylist> getPlaylist(@RequestBody PlaylistRequest request) {
		CervejaPlaylist playlist = service.getPlaylist(request.getTemperatura());
		return ResponseEntity.ok(playlist);
	}

}
