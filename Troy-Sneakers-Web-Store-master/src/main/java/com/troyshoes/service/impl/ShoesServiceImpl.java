package com.troyshoes.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.troyshoes.domain.Shoes;
import com.troyshoes.repository.ShoesRepository;
import com.troyshoes.service.ShoesService;

@Service
public class ShoesServiceImpl implements ShoesService{
	
	@Autowired
	private ShoesRepository shoesRepository;
	
	public List<Shoes> findAll() {
		return (List<Shoes>) shoesRepository.findAll();
	}
	
	public Shoes findOne(Long id) {
		return shoesRepository.findById(id).get();
	}

}
