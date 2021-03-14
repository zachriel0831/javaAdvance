package com.ntu.shoppingcart.service;

import com.ntu.shoppingcart.model.User;

public interface ShoppingCartService {

	public Integer findTotalCount(User user);
	
	public void add(User user, Integer productId, Integer count);
}
