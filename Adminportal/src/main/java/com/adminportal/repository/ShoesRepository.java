package com.adminportal.repository;

import org.springframework.data.repository.CrudRepository;

import com.adminportal.domain.Shoes;

public interface ShoesRepository extends CrudRepository<Shoes, Long> {

}
