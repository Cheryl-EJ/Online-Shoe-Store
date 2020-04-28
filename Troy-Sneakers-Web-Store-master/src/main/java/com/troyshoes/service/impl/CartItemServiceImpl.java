package com.troyshoes.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.troyshoes.domain.CartItem;
import com.troyshoes.domain.Shoes;
import com.troyshoes.domain.ShoesToCartItem;
import com.troyshoes.domain.ShoppingCart;
import com.troyshoes.domain.User;
import com.troyshoes.repository.CartItemRepository;
import com.troyshoes.repository.ShoesToCartItemRepository;
import com.troyshoes.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService{
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired ShoesToCartItemRepository shoesToCartItemRepository;
	
	public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart){
		return cartItemRepository.findByShoppingCart(shoppingCart);
	}
	
	public CartItem updateCartItem(CartItem cartItem) {
		BigDecimal bigDecimal = new BigDecimal(cartItem.getShoes().getOurPrice()).multiply(new BigDecimal(cartItem.getQty()));
		
		bigDecimal = bigDecimal.setScale(2, RoundingMode.CEILING);
		cartItem.setSubtotal(bigDecimal);
		
		cartItemRepository.save(cartItem);
		
		return cartItem;
	}
	
	public CartItem addShoesToCartItem(Shoes shoes, User user, int qty) {
		
		List<CartItem> cartItemList = findByShoppingCart(user.getShoppingCart());
		
		for (CartItem cartItem : cartItemList) {
			if(shoes.getId() == cartItem.getShoes().getId()) {
				cartItem.setQty(cartItem.getQty()+qty);
				cartItem.setSubtotal(new BigDecimal(shoes.getOurPrice()).multiply(new BigDecimal(qty)));
				cartItemRepository.save(cartItem);
				return cartItem;
			}
		}
		
		CartItem cartItem = new CartItem();
		cartItem.setShoppingCart(user.getShoppingCart());
		cartItem.setShoes(shoes);
		
		cartItem.setQty(qty);
		cartItem.setSubtotal(new BigDecimal(shoes.getOurPrice()).multiply(new BigDecimal(qty)));
		cartItem = cartItemRepository.save(cartItem);
		
		ShoesToCartItem shoesToCartItem = new ShoesToCartItem();
		shoesToCartItem.setShoes(shoes);
		shoesToCartItem.setCartItem(cartItem);
		shoesToCartItemRepository.save(shoesToCartItem);
		
		return cartItem;
	}
	
	public CartItem save(CartItem cartItem) {
		return cartItemRepository.save(cartItem);
	}
	
	public CartItem findById(Long id) {
		return cartItemRepository.findById(id).get();
	}
	
	public void removeCartItem(CartItem cartItem) {
		shoesToCartItemRepository.deleteByCartItem(cartItem);
		cartItemRepository.delete(cartItem);
	}
		

}
