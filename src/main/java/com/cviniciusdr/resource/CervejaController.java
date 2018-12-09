package com.cviniciusdr.resource;

import static java.util.Objects.isNull;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.cviniciusdr.exception.BadRequestException;
import com.cviniciusdr.model.Cerveja;
import com.cviniciusdr.service.CervejariaService;

@RestController
public class CervejaController implements CervejaResource {

	@Autowired
	private CervejariaService cervejariaService;
	
	@Override
	public ResponseEntity<List<Cerveja>> listaCervejas() {
		List<Cerveja> cervejas = cervejariaService.listaCervejas();
		return ResponseEntity.ok(cervejas);
	}

	@Override
	public ResponseEntity<Cerveja> listaCerveja(@PathVariable long id) {
		Cerveja cerveja = cervejariaService.listaCervejaPorId(id); 
		
		return ResponseEntity.ok(cerveja);
	}

	@Override
	public ResponseEntity<Cerveja> criaCerveja(@Valid @RequestBody Cerveja request, UriComponentsBuilder b) {
		Cerveja cerveja = cervejariaService.salvaCerveja(request);
		UriComponents uriComponents = b.path("/cerveja/{id}").buildAndExpand(cerveja.getId());
		return ResponseEntity.created(uriComponents.toUri()).body(cerveja);

	}
	
	@Override
	public ResponseEntity<Cerveja> atualizaCerveja(Cerveja request, UriComponentsBuilder b) {
		if(isNull(request.getId())) {
			throw new BadRequestException();

		}
		Cerveja cerveja = cervejariaService.salvaCerveja(request);
		return ResponseEntity.ok(cerveja);	
	}
	
	@Override
	public ResponseEntity<?> deletaCerveja(@PathVariable long id) {
		cervejariaService.deletaCervejaPorId(id);
		return ResponseEntity.accepted().build();

	}

	
}
