package com.ntu.shoppingcart.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ntu.shoppingcart.model.common.Product;

@Controller
@RequestMapping("/index")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class IndexController {
	
	@GetMapping("/login")
	public String loginPage(Model model) {

		Product product = new Product();
		model.addAttribute("products", product);
		model.addAttribute("greetings", "hello world");

		return "frontend/login";
	}
	
	@PostMapping("/logon")
	public String loginPage(Authentication authentication) {

		return "frontend/index";
	}

}
