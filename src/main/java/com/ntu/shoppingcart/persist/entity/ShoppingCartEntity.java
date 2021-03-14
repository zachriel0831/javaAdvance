package com.ntu.shoppingcart.persist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="shopping_cart")
public class ShoppingCartEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cart_id")
	private Integer id;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name = "product_id")
	private Integer productId;
	
	@Column
	private Integer count;
	
}
