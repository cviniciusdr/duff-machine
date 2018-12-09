package com.cviniciusdr.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.cviniciusdr.model.Cerveja;

@RequestMapping("cerveja")
public interface CervejaResource {

	@GetMapping
	ResponseEntity<List<Cerveja>> listaCervejas();

	@GetMapping("/{id}")
	ResponseEntity<Cerveja> listaCerveja(long id);

	@PostMapping
	ResponseEntity<Cerveja> criaCerveja(Cerveja request, UriComponentsBuilder b);

	@PutMapping
	ResponseEntity<Cerveja> atualizaCerveja(Cerveja request, UriComponentsBuilder b);
	
	@DeleteMapping("/{id}")
	ResponseEntity<?> deletaCerveja(long id);
}
