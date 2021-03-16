package com.ntu.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/selectAllProducts")
	public String selectAllProducts() {
		List<Product> responseResult = productService.selectAllProduct();

		return toJsonStr(responseResult);
	}

	@RequestMapping("/addNewProduct")
	public String addNewProduct(@RequestBody Product product) {

		List<Product> responseResult = productService.addNewProduct(product);

		return toJsonStr(responseResult);
	}

	@RequestMapping("/deleteProducts")
	public String deleteProducts(@RequestBody List<Integer> productsIds) {

		List<Product> responseResult = productService.deleteProducts(productsIds);

		return toJsonStr(responseResult);
	}

	@RequestMapping("/updateProduct")
	public String updateProduct(@RequestBody Product product) {

		List<Product> responseResult = productService.updateProduct(product);

		return toJsonStr(responseResult);
	}

	public <T> String toJsonStr(List<T> model) {

		Gson gson = new Gson();

		String response = gson.toJson(model);
		return response;
	}

}
