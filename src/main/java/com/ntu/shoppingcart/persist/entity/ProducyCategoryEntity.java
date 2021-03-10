package com.ntu.shoppingcart.persist.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="producy_category")
@Data
public class ProducyCategoryEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "category_id", unique = true, nullable = false, length = 50)
	private Integer category_id;
	
	/**
	 * 順序
	 */
	@Column
	private Integer order;
	
	/**
	 * 商品種類名稱
	 */
	@Column
	private String category_name;
}
