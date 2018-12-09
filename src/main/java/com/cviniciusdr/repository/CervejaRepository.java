package com.cviniciusdr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cviniciusdr.model.Cerveja;

@Repository
public interface CervejaRepository extends CrudRepository<Cerveja, Long>{

}
