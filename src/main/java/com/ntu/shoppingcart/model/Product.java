package com.ntu.shoppingcart.model;

import lombok.Data;

@Data
public class Product {

	private String name;
	
	private String url;
	
	private String price;
	
	private String stock;
	
	private String description;
	
	public Product(String name, String url, String price, String stock, String description) {
		this.name = name;
		this.url = url;
		this.price = price;
		this.stock = stock;
		this.description = description;
	}
	
}
