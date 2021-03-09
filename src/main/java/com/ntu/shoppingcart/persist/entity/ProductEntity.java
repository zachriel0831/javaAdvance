package com.ntu.shoppingcart.persist.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

/**
 * 商品
 *
 */
@Entity
@Table(name="Product")
@Data
public class ProductEntity {

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

	@Lob
	private byte[] image_data;

	@Column(name = "create_time")
	private Date createTime;
	
	@Column(name = "update_time")
	private Date updateTime;

}
