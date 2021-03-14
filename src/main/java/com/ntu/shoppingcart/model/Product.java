package com.ntu.shoppingcart.model;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
	
	private Integer productId;
	
	private Integer categoryId;
	
	private String productName;

	private String url;

	private String productPrice;

	private String productStock;

	private String description;

	private Date createTime;

	private Date updateTime;

	private Date previousUpdateTime;

	private String imageDir;

	public Product(Integer productId, Integer categoryId, String productName, String url, String productPrice,
			String productStock, String description, Date createTime, Date updateTime, Date previousUpdateTime,
			String imageDir) {
		super();
		this.productId = productId;
		this.categoryId = categoryId;
		this.productName = productName;
		this.url = url;
		this.productPrice = productPrice;
		this.productStock = productStock;
		this.description = description;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.previousUpdateTime = previousUpdateTime;
		this.imageDir = imageDir;
	}

}
