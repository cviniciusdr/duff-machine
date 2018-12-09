package com.cviniciusdr.service;

import java.util.List;

import com.cviniciusdr.model.Cerveja;

public interface CervejariaService {

	List<Cerveja> listaCervejas();

	Cerveja listaCervejaPorId(long id);

	Cerveja salvaCerveja(Cerveja request);

	void deletaCervejaPorId(long id);


}
