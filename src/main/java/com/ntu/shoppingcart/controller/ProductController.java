package com.ntu.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ntu.shoppingcart.model.Product;
import com.ntu.shoppingcart.service.impl.ProductServiceImpl;

@Controller
@RequestMapping("/product")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {
	@Autowired
	ProductServiceImpl productServiceImpl;

	@RequestMapping("/addNewProduct")
	public String loginPage(@RequestBody Product product, Model model) {

		List<Product> responseResult = productServiceImpl.addNewProduct(product);

		model.addAttribute("products", responseResult);
		model.addAttribute("greetings", "hello world");

		return "frontend/login";
	}
}
