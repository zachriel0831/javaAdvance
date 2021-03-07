package com.ntu.shoppingcart.persist.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ProductEntites {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id", unique = true, nullable = false, length = 50)
	private Integer product_id;

	@Column(name = "product_name", unique = false, nullable = false, length = 50)
	private String product_name;

	@Column(name = "product_stock", unique = false, nullable = false, length = 50)
	private String product_stock;

	@Column(name = "product_price", unique = false, nullable = false, length = 50)
	private String product_price;

	@Column(name = "product_img_url", unique = false, nullable = false, length = 50)
	private String product_img_url;

	@Column(name = "create_time")
	private Date createTime;
	
	@Column(name = "update_time")
	private Date updateTime;

}
