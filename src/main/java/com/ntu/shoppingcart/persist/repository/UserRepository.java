package com.ntu.shoppingcart.persist.repository;

import org.springframework.data.repository.Repository;

import com.ntu.shoppingcart.persist.entity.UserEntity;

public interface UserRepository extends Repository<UserEntity, Integer> {

	public UserEntity findByUserName(String userName);
}
