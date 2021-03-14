package com.ntu.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntu.shoppingcart.model.User;
import com.ntu.shoppingcart.service.ShoppingCartService;

@RestController
@RequestMapping("/shopping/cart")
public class ShoppingCartController extends BaseController {

	@Autowired
	private ShoppingCartService shoppingCartService;

	@Secured("user")
	@GetMapping("/add")
	public void addProductToCart(@PathVariable("productId") Integer productId) {
		User user = getLoginUser();
		shoppingCartService.add(user, productId, 1);
		Integer totalCount =  shoppingCartService.findTotalCount(user);
		updateShoppingCartCount(totalCount);
		
//		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
