package com.ntu.shoppingcart.service;

import java.math.BigDecimal;
import java.util.List;

import com.ntu.shoppingcart.model.ShoppingCartDetail;
import com.ntu.shoppingcart.model.User;

public interface ShoppingCartService {

	public Integer findTotalCount(User user);
	
	public void add(User user, Integer productId, Integer count);
	
	public List<ShoppingCartDetail> findMyCartList(User user);
	
	public BigDecimal getTotal(List<ShoppingCartDetail> myCartList);
	
	public BigDecimal getSubTotal(Integer productId, Integer count);
}
