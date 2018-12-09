package com.cviniciusdr.service.impl;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cviniciusdr.exception.NotFoundException;
import com.cviniciusdr.model.Cerveja;
import com.cviniciusdr.repository.CervejaRepository;
import com.cviniciusdr.service.CervejariaService;

@Service
public class CervejariaServiceImpl implements CervejariaService {

	private final CervejaRepository repository;
	
	public CervejariaServiceImpl(CervejaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Cerveja listaCervejaPorId(long id) {
		Cerveja cerveja = repository.findOne(id);

		if (isNull(cerveja)) {
			throw new NotFoundException();
		}
		return cerveja;
	}

	@Override
	public List<Cerveja> listaCervejas() {
		List<Cerveja> cervejas = new ArrayList<>();
		repository.findAll().forEach(cervejas::add);
		return cervejas;
	}

	@Override
	public Cerveja salvaCerveja(Cerveja cerveja) {
		return repository.save(cerveja);
	}

	@Override
	public void deletaCervejaPorId(long id) {
		repository.delete(id);
	}
	
}
