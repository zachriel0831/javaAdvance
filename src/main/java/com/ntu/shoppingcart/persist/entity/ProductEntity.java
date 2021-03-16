package com.ntu.shoppingcart.persist.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 商品
 *
 */
@Entity
@Table(name="product")
@Data
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id", unique = true, nullable = false, length = 50)
	private Integer productId;
	
	
	/**
	 * 商品類別id 
	 */
	@Column(name = "category_id")
	private Integer categoryId;

	@Column(name = "product_name", unique = false, nullable = false, length = 50)
	private String productName;

	@Column(name = "product_stock", unique = false, nullable = false, length = 50)
	private String productStock;

	@Column(name = "product_price", unique = false, nullable = false, length = 50)
	private String productPrice;

	/**
	 * 商品描述、說明
	 */
	@Column(length=5000)
	private String description;
	
	/**
	 * 建立時間
	 */
	@Column(name = "create_time")
	private Date createTime;
	
	/**
	 * 更新時間
	 */
	@Column(name = "update_time")
	private Date updateTime;
	
	/**
	 * 上一次更新時間
	 */
	@Column(name = "previous_update_time")
	private Date previousUpdateTime;
	
	/**
	 * 圖片路徑
	 */
	@Column(name = "image_dir")
	private String imageDir;
	
	/**
	 * 狀態參數 0 刪除 , 1上架
	 */
	@Column(name = "status", unique = false, nullable = false, length = 50)
	private String status;

}
