package com.ntu.shoppingcart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ntu.shoppingcart.model.common.Product;

@Controller
@RequestMapping("/a")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class IndexController {
	
	@GetMapping("/index2")
	public String Home_Page(Model model) {

		Product product = new Product();
		model.addAttribute("products", product);
		model.addAttribute("greetings", "hello world");

		return "frontend/index";
	}

}
