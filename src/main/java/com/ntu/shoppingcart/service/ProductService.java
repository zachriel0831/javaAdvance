package com.ntu.shoppingcart.service;

import java.util.List;

import com.ntu.shoppingcart.model.Product;

public interface ProductService {
	List<Product> addNewProduct(Product product);
}
