package com.ntu.shoppingcart.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ShoppingCartDetail {
	private Integer productId;
	private String img;
	private String name;
	private String inStock;
	private BigDecimal price;
	private Integer stock;
}
