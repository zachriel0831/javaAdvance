package com.ntu.shoppingcart.persist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 產品類別
 *
 */
@Entity
@Table(name = "product_category")
@Data
public class ProductCategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "category_id", unique = true, nullable = false, length = 50)
	private Integer categoryId;

	/**
	 * 種類名稱
	 */
	@Column(name = "category_name")
	private String categoryName;

	/**
	 * 順序
	 */
	@Column(name = "order_number")
	private Integer orderNumber;
	
	
	@Column(name = "image_dir")
	private String imageDir;
}
