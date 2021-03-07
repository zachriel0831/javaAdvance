package com.ntu.shoppingcart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntu.shoppingcart.models.common.Products;

@Controller
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class IndexController {

	@GetMapping("/index")
	public String Home_Page(Model model) {

		Products products = new Products();
		model.addAttribute("products", products);
		model.addAttribute("greetings", "hello world");

		return "index";
	}

}
