package com.cviniciusdr.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CervejaTest {

	double delta = 0.01;
	private Cerveja cerveja;

	@Before
	public void init() {
		cerveja = new Cerveja("IPA", -2D, 5D);

	}
	@Test
	public void testaConstrutor() {
		assertEquals("IPA", cerveja.getEstilo());
		assertEquals(-2D, cerveja.getTemperaturaMin(), delta);
		assertEquals(5D, cerveja.getTemperaturaMax(), delta);

	}
	
	@Test
	public void testaMedia() {
		assertEquals(1.5D, cerveja.getTemperaturaMedia(), delta);

	}

}
