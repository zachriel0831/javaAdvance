package com.ntu.shoppingcart.persist.entity;
//package com.ntu.shoppingcart.persist.entities;
//
//import java.util.Date;
//import java.util.List;
//
//import javax.persistence.CollectionTable;
//import javax.persistence.Column;
//import javax.persistence.ElementCollection;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//import lombok.Data;
//
//@Entity
//@Data
//public class OrderEntities {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "order_id", unique = true, nullable = false, length = 50)
//	private Integer order_id;
//
//	@Column(name = "order_user_id", unique = false, nullable = false, length = 50)
//	private String order_user_id;
//
//	@ElementCollection
//	@CollectionTable(name ="OrderEntities")
//	private List<String> product_id_list;
//
//	@Column(name = "order_price", unique = false, nullable = false, length = 50)
//	private String order_price;
//
//	@Column(name = "create_time")
//	private Date createTime;
//	
//	@Column(name = "update_time")
//	private Date update_time;
//}
