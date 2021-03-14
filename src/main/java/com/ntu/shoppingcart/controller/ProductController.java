package com.ntu.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ntu.shoppingcart.model.Product;
import com.ntu.shoppingcart.service.ProductService;

@Controller
@RequestMapping("/product")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController extends BaseController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = "/catalog/{category}")
	public String loginPage(@PathVariable("category") String category, Model model) {
		List<Product> products = productService.findProductsByCategory(category);
		model.addAttribute("products", products);
		model.addAttribute("notEmpty", products.size() > 0);
		model.addAttribute("itemSize", products.size());
		return "product-catalog";
	}

}
