package com.troyshoes.service;


import java.util.List;

import com.troyshoes.domain.Shoes;

public interface ShoesService {
	List<Shoes> findAll();
	
	Shoes findOne(Long id);
}
