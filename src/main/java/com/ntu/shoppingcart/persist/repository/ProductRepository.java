package com.ntu.shoppingcart.persist.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.ntu.shoppingcart.persist.entity.ProductEntity;

public interface ProductRepository extends Repository<ProductEntity, Integer> {

	public List<ProductEntity> findByCategoryId(Integer categoryId);
}
