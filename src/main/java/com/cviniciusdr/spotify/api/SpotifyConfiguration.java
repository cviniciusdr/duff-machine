package com.cviniciusdr.spotify.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cviniciusdr.spotify.exception.SpotifyClientException;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;

@Configuration
public class SpotifyConfiguration {

	private String clientId = "68e112fdf58e4e6191b6a07b7e144f64";

	private String clientSecret ="a6b1c9ee9f27405785acf169a695af78";

	private final SpotifyApi spotifyApi = new SpotifyApi.Builder()//
			.setClientId(clientId)//
			.setClientSecret(clientSecret)//
			.build();

	private final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();

	@Bean
	public SpotifyApi spotifyApi() {

		try {
			final ClientCredentials clientCredentials = clientCredentialsRequest.execute();
			spotifyApi.setAccessToken(clientCredentials.getAccessToken());
		} catch (Exception e) {
			throw new SpotifyClientException();
		}
		return spotifyApi;

	}

}
