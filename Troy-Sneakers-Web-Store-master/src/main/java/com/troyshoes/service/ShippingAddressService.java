package com.troyshoes.service;

import com.troyshoes.domain.ShippingAddress;
import com.troyshoes.domain.UserShipping;

public interface ShippingAddressService {
	
	ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);
}
