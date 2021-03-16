package com.ntu.shoppingcart.service;

import java.util.List;

import com.ntu.shoppingcart.model.Product;

public interface ProductService {

	public List<Product> findProductsByCategory(String categoryId);

	public List<Product> addNewProduct(Product product);

	public List<Product> deleteProducts(List<Integer> productsIds);
	
	public List<Product> updateProduct(Product product);

	public List<Product> selectAllProduct();
}
