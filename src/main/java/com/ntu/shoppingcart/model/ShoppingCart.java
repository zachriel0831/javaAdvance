package com.ntu.shoppingcart.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ShoppingCart extends JsonModel {

	private Integer productId;
	
	private Integer count;
}
