package com.ntu.shoppingcart.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ntu.shoppingcart.model.User;
import com.ntu.shoppingcart.model.common.Product;

@Controller
@RequestMapping("/qq")
public class UserController extends BaseController {

	
	@Secured("user")
	@GetMapping("/page1")
	public String loginPage(Model model) {

		User user = getLoginUser();
		
		System.out.println("UserId:" + user.getUserId());
		
		
		Product product = new Product();
		model.addAttribute("products", product);
		model.addAttribute("greetings", "hello world");

		return "frontend/qq";
	}
	
}
