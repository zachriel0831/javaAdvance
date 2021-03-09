package com.ntu.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ntu.shoppingcart.service.ProductService;

@Controller("/")
public class MainController {
	
	@Autowired
	private ProductService productService;
	
	/**
	 * 首頁
	 * @return
	 */
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	

}
