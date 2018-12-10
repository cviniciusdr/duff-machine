package com.cviniciusdr.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cviniciusdr.model.Cerveja;
import com.cviniciusdr.service.CervejariaService;
import com.cviniciusdr.spotify.api.service.SpotifyService;

@RunWith(MockitoJUnitRunner.class)
public class PlaylistServiceImplTest {

	private List<Cerveja> cervejas;

	@InjectMocks
	private PlaylistServiceImpl playlistService;

	@Mock
	private CervejariaService cervejariaServicervice;

	@Mock
	private SpotifyService spotifyServicex;
	

	@Before
	public void init() {
		cervejas = new ArrayList<>();

		cervejas.add(new Cerveja("Weissbier", -1D, 3D));
		cervejas.add(new Cerveja("Pilsens", -2D, 4D));
		cervejas.add(new Cerveja("Weizenbier", -4D, 6D));
		cervejas.add(new Cerveja("Red ale", -5D, 5D));
		cervejas.add(new Cerveja("India pale ale", -6D, 7D));
		cervejas.add(new Cerveja("IPA", -7D, 10D));
		cervejas.add(new Cerveja("Dunkel", -8D, 2D));
		cervejas.add(new Cerveja("Imperial Stouts", -10D, 13D));
		cervejas.add(new Cerveja("Brown ale", 0D, 14D));
	}
	
	@Test
	public void escolheAMaisQuente() {
		when(cervejariaServicervice.listaCervejas()).thenReturn(cervejas);
		Cerveja cerveja = playlistService.escolheCervejaPorMediaTemperatura(14D);
		
        assertEquals("Brown ale", cerveja.getEstilo());
	}
	
	@Test
	public void quandoDistanciaIgualDeveEscolherPorEstiloEmOrdemAlfabetica() {
		when(cervejariaServicervice.listaCervejas()).thenReturn(cervejas);
		Cerveja cerveja = playlistService.escolheCervejaPorMediaTemperatura(-2D);
        assertEquals("Dunkel", cerveja.getEstilo());

	}
	

}
