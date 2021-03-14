package com.ntu.shoppingcart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntu.shoppingcart.model.User;
import com.ntu.shoppingcart.persist.entity.ShoppingCartEntity;
import com.ntu.shoppingcart.persist.repository.ShoppingCartRepository;
import com.ntu.shoppingcart.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	@Override
	public Integer findTotalCount(User user) {
		return shoppingCartRepository.findTotalCount(user.getUserId());
	}
	
	@Override
	public void add(User user, Integer productId) {
		Integer count = shoppingCartRepository.findCountByUserIdAndProductId(user.getUserId(), productId);

		ShoppingCartEntity shoppingCartEntity = new ShoppingCartEntity();
		shoppingCartEntity.setCount(1);
		shoppingCartEntity.setUserId(user.getUserId());
		shoppingCartEntity.setProductId(productId);

		shoppingCartRepository.save(shoppingCartEntity);
	}



}
