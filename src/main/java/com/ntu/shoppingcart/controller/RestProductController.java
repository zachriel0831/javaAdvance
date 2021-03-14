package com.ntu.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.ntu.shoppingcart.model.Product;
import com.ntu.shoppingcart.service.ProductService;

@RestController
@RequestMapping("/restProduct")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RestProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping("/addNewProduct")
	public String addNewProduct(@RequestBody Product product) {

		List<Product> responseResult = productService.addNewProduct(product);

		Gson gson = new Gson();

		String response = gson.toJson(responseResult);

		return response;
	}

}
