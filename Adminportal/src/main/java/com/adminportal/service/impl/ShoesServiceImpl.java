package com.adminportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminportal.domain.Shoes;
import com.adminportal.repository.ShoesRepository;
import com.adminportal.service.ShoesService;

@Service
public class ShoesServiceImpl implements ShoesService{
	
	@Autowired
	private ShoesRepository shoesRepository;
	
	public Shoes save(Shoes shoes) {
		return shoesRepository.save(shoes);
	}
	
	public List<Shoes> findAll() {
		return (List<Shoes>) shoesRepository.findAll();
	}
}
