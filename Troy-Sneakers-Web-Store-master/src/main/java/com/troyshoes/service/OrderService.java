package com.troyshoes.service;

import com.troyshoes.domain.BillingAddress;
import com.troyshoes.domain.Order;
import com.troyshoes.domain.Payment;
import com.troyshoes.domain.ShippingAddress;
import com.troyshoes.domain.ShoppingCart;
import com.troyshoes.domain.User;

public interface OrderService {
	Order createOrder(ShoppingCart shoppingCart,
			ShippingAddress shippingAddress,
			BillingAddress billingAddress,
			Payment payment,
			String shippingMethod,
			User user);
}
