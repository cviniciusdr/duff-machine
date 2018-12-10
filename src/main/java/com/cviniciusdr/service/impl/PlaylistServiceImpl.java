package com.cviniciusdr.service.impl;

import static org.springframework.util.CollectionUtils.isEmpty;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cviniciusdr.exception.NotFoundException;
import com.cviniciusdr.model.Cerveja;
import com.cviniciusdr.service.CervejariaService;
import com.cviniciusdr.service.PlaylistService;
import com.cviniciusdr.spotify.api.service.SpotifyService;
import com.cviniciusdr.spotify.model.CervejaPlaylist;
import com.wrapper.spotify.model_objects.specification.PlaylistSimplified;
import com.wrapper.spotify.model_objects.specification.PlaylistTrack;

@Service
public class PlaylistServiceImpl implements PlaylistService {

	private final SpotifyService service;
	private final CervejariaService cervejariaService;

	public PlaylistServiceImpl(SpotifyService service, CervejariaService cervejariaService) {
		this.service = service;
		this.cervejariaService = cervejariaService;
	}

	@Override
	public CervejaPlaylist getPlaylist(Double temperatura) {
		Cerveja cerveja = escolheCervejaPorMediaTemperatura(temperatura);
		PlaylistSimplified playlist = service.getPlaylistPorEstiloCerveja(cerveja.getEstilo());
		List<PlaylistTrack> playlistTracks = service.getPlaylistTracks(playlist.getId());

		CervejaPlaylist cervejaPlaylist = new CervejaPlaylist().build(cerveja.getEstilo(), playlist.getName(),
				playlistTracks);

		return cervejaPlaylist;
	}

	public Cerveja escolheCervejaPorMediaTemperatura(Double temperatura) {
		List<Cerveja> listaCervejas = cervejariaService.listaCervejas();

		if (isEmpty(listaCervejas)) {
			throw new NotFoundException();
		}

		Comparator<Cerveja> comparator = Comparator.comparing((Cerveja c) -> c.getDistancia(temperatura))
				.thenComparing(Cerveja::getEstilo);

		listaCervejas.sort(comparator);
		return listaCervejas.get(0);
	}
}
