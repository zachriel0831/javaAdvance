package com.ntu.shoppingcart.persist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ntu.shoppingcart.persist.entity.ShoppingCartEntity;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCartEntity, Integer> {

	@Query("select sum(u.count) from ShoppingCartEntity u where u.userId =?1  ")
	public Integer findTotalCount(Integer userId);

	@Query("select u from ShoppingCartEntity u where u.userId =?1  and u.productId =?2")
	public ShoppingCartEntity findByUserIdAndProductId(Integer userId, Integer productId);
	
	@Query("select u from ShoppingCartEntity u where u.userId =?1")
	public List<ShoppingCartEntity> findAllByUserId(Integer userId);
}
