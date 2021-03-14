package com.ntu.shoppingcart.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
	public void add(User user, Integer productId, Integer count) {

		ShoppingCartEntity entity = Optional
				.ofNullable(shoppingCartRepository.findByUserIdAndProductId(user.getUserId(), productId)).orElse(new ShoppingCartEntity());

		ShoppingCartEntity shoppingCartEntity = new ShoppingCartEntity();

		if (!ObjectUtils.isEmpty(entity.getId())) {
			shoppingCartEntity.setId(entity.getId());
		}
		Integer nowCount = shoppingCartEntity.getCount() == null ? 0 : shoppingCartEntity.getCount();
		shoppingCartEntity.setCount(nowCount + count);
		shoppingCartEntity.setUserId(user.getUserId());
		shoppingCartEntity.setProductId(productId);
		shoppingCartRepository.save(shoppingCartEntity);
	}

}
