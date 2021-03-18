package com.ntu.shoppingcart.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ntu.shoppingcart.model.ShoppingCart;
import com.ntu.shoppingcart.model.ShoppingCartDetail;
import com.ntu.shoppingcart.model.User;
import com.ntu.shoppingcart.service.ShoppingCartService;

@RestController
@RequestMapping("/shopping/cart")
public class ShoppingCartController extends BaseController {

	@Autowired
	private ShoppingCartService shoppingCartService;

	@Secured("user")
	@PostMapping("/add")
	public ShoppingCart addProductToCart(@RequestBody ShoppingCart shoppingCart) {
		User user = getLoginUser();
		shoppingCartService.add(user, shoppingCart.getProductId() , 1);
		Integer totalCount =  shoppingCartService.findTotalCount(user);
		updateShoppingCartCount(totalCount);
		
		ShoppingCart result = new ShoppingCart();
		result.setCount(totalCount);
		result.setSuccess(true);
		return result;
	}
	
	@Secured("user")
	@PostMapping("/subtotal")
	public ShoppingCart subtotal(@RequestBody ShoppingCart shoppingCart) {
		User user = getLoginUser();
		ShoppingCart result = new ShoppingCart();
		
		
		return result;
	}
	
	
	@Secured("user")
	@GetMapping("/mylist")
	public ModelAndView shoppingCartPage() {
		ModelAndView view = new ModelAndView("shopcart");
		User user = getLoginUser();
		List<ShoppingCartDetail> myCartList = shoppingCartService.findMyCartList(user);
		
		BigDecimal total = shoppingCartService.getTotal(myCartList);
		
		view.addObject("myCartList", myCartList);
		view.addObject("total", total);
		
		return view;
	}
	
}
