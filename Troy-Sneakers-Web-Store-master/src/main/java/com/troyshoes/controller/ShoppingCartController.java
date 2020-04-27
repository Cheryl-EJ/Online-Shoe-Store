package com.troyshoes.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.troyshoes.domain.CartItem;
import com.troyshoes.domain.Shoes;
import com.troyshoes.domain.ShoppingCart;
import com.troyshoes.domain.User;
import com.troyshoes.service.CartItemService;
import com.troyshoes.service.ShoesService;
import com.troyshoes.service.ShoppingCartService;
import com.troyshoes.service.UserService;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ShoesService shoesService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@RequestMapping("/cart")
	public String shoppingCart(Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		ShoppingCart shoppingCart = user.getShoppingCart();
		
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		shoppingCartService.updateShoppingCart(shoppingCart);
		
		model.addAttribute("user", user);
		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("shoppingCart",shoppingCart);
		
		return "shoppingCart";
	}
	
	@RequestMapping("/addItem")
	public String addItem(
			@ModelAttribute("shoes") Shoes shoes,
			@ModelAttribute("qty") String qty,
			Model model, Principal principal
			) {
		User user = userService.findByUsername(principal.getName());
		shoes = shoesService.findOne(shoes.getId());
	
		if (Integer.parseInt(qty) > shoes.getInStockNumber()) {
			model.addAttribute("notEnoughStock", true);
			return "forward:/shoesDetail?id="+shoes.getId();
		}
		
		CartItem cartItem = cartItemService.addShoesToCartItem(shoes, user, Integer.parseInt(qty));
		model.addAttribute("addShoesSuccess", true);
		
		return "forward:/shoesDetail?id="+shoes.getId();
	}

	
	

}
