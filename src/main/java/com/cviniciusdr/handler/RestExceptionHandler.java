package com.cviniciusdr.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cviniciusdr.exception.BadRequestException;
import com.cviniciusdr.exception.NotFoundException;
import com.cviniciusdr.spotify.exception.NoPlaylistFoundException;
import com.cviniciusdr.spotify.exception.SpotifyClientException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Object> handleNotFound() {
		return ResponseEntity.notFound().build();
		
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<Object> handleBadRequest() {
		return ResponseEntity.badRequest().build();
		
	}
	
	@ExceptionHandler(NoPlaylistFoundException.class)
	public ResponseEntity<Object> handleNoPlaylistFoundException() {
		return ResponseEntity.notFound().build();
		
	}
	
	@ExceptionHandler(SpotifyClientException.class)
	public ResponseEntity<Object> handleSpotifyClientException() {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		
	}
}
