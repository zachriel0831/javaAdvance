package com.ntu.shoppingcart.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Product {
	
	private String productId;
	
	private String categoryId;
	
	private String productName;

	private String url;

	private String productPrice;

	private String productStock;

	private String description;

	private String createTime;

	private String updateTime;

	private String previousUpdateTime;

	private String imageDir;

}
