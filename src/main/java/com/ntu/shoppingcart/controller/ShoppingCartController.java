package com.ntu.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ntu.shoppingcart.model.User;
import com.ntu.shoppingcart.service.ShoppingCartService;

@Controller
@RequestMapping("/shopping/cart")
public class ShoppingCartController extends BaseController {

	@Autowired
	private ShoppingCartService shoppingCartService;

	@Secured("user")
	@GetMapping("/add/{productId}")
	public void addProductToCart(@PathVariable("productId") Integer productId) {
		User user = getLoginUser();
		shoppingCartService.add(user, productId);
		Integer count =  shoppingCartService.findTotalCount(user);
		addProductToCart(count);
		
		System.out.println("12345qq");
	}
	
	
	
}
