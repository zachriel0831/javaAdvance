package com.ntu.shoppingcart.model;

import lombok.Data;

@Data
public class ProductCataLog {

	private String id;
	
	private String name;
	
	private String url;
	
	public ProductCataLog(String id, String name, String url) {
		this.id = id;
		this.name = name;
		this.url = url;
	}
	
	public ProductCataLog() {
		
	}
	
}
