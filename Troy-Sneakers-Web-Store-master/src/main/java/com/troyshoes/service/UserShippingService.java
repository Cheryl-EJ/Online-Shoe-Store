package com.troyshoes.service;

import com.troyshoes.domain.UserShipping;

public interface UserShippingService {
	UserShipping findById(Long id);
	
	void removeById(Long id);

}
