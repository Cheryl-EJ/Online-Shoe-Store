package com.troyshoes.repository;

import org.springframework.data.repository.CrudRepository;

import com.troyshoes.domain.Shoes;

public interface ShoesRepository extends CrudRepository<Shoes, Long>{

}
