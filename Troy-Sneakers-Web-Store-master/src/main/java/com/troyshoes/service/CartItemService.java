package com.troyshoes.service;

import java.util.List;

import com.troyshoes.domain.CartItem;
import com.troyshoes.domain.Shoes;
import com.troyshoes.domain.ShoppingCart;
import com.troyshoes.domain.User;

public interface CartItemService {
	
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
	CartItem updateCartItem(CartItem cartItem);
	
	CartItem addShoesToCartItem(Shoes shoes, User user, int qty);
	
    CartItem save(CartItem cartItem);
}
