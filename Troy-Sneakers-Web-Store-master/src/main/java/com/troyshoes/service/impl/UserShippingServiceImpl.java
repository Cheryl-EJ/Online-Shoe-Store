package com.troyshoes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.troyshoes.domain.UserShipping;
import com.troyshoes.repository.UserShippingRepository;
import com.troyshoes.service.UserShippingService;

@Service
public class UserShippingServiceImpl implements UserShippingService{

	@Autowired
	private UserShippingRepository userShippingRepository;
	
	public UserShipping findById(Long id) {
		return userShippingRepository.findById(id).get();
	}
	
	public void removeById(Long id) {
		userShippingRepository.deleteById(id);
	}
}
