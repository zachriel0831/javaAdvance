package com.ntu.shoppingcart.model;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ShoppingCart extends JsonModel {

	private Integer productId;
	
	private Integer count;
	
	private BigDecimal price;
	
}
