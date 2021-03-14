package com.ntu.shoppingcart.model;

import lombok.Data;

@Data
public class ProductCataLog {

	private String imgDir;
	
	private String name;
	
	private String url;
	
	public ProductCataLog(String imgDir, String name, String url) {
		this.imgDir = imgDir;
		this.name = name;
		this.url = url;
	}
	
	public ProductCataLog() {
		
	}
	
}
