package com.troyshoes.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.troyshoes.domain.BillingAddress;
import com.troyshoes.domain.CartItem;
import com.troyshoes.domain.Order;
import com.troyshoes.domain.Payment;
import com.troyshoes.domain.ShippingAddress;
import com.troyshoes.domain.Shoes;
import com.troyshoes.domain.ShoppingCart;
import com.troyshoes.domain.User;
import com.troyshoes.repository.OrderRepository;
import com.troyshoes.service.CartItemService;
import com.troyshoes.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CartItemService cartItemService;
	
	public synchronized Order createOrder(ShoppingCart shoppingCart,
			ShippingAddress shippingAddress,
			BillingAddress billingAddress,
			Payment payment,
			String shippingMethod,
			User user) {
		Order order = new Order();
		order.setBillingAddress(billingAddress);
		order.setOrderStatus("created");
		order.setPayment(payment);
		order.setShippingAddress(shippingAddress);
		order.setShippingMethod(shippingMethod);
		
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		for(CartItem cartItem : cartItemList) {
			Shoes shoes = cartItem.getShoes();
			cartItem.setOrder(order);
			shoes.setInStockNumber(shoes.getInStockNumber() - cartItem.getQty());
		}
		
		order.setCartItemList(cartItemList);
		order.setOrderDate(Calendar.getInstance().getTime());
		order.setOrderTotal(shoppingCart.getGrandTotal());
		shippingAddress.setOrder(order);
		billingAddress.setOrder(order);
		payment.setOrder(order);
		order.setUser(user);
		order = orderRepository.save(order);
		
		return order;
	}
	
	

}
