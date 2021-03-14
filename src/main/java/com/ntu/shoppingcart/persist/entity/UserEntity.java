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
@Table(name="user")
public class UserEntity {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	@Column(name = "user_name", unique = false, nullable = false, length = 50)
	private String userName;

	@Column(name = "user_password", unique = false, nullable = false, length = 50)
	private String userPwd;
	
	@Column
	private boolean enabled;
	
	@Column
	private String role;
	
//	@Column(name = "create_time")
//	private Date createTime;
//	
//	@Column(name = "update_time")
//	private Date updateTime;
}
