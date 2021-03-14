package com.ntu.shoppingcart.persist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ntu.shoppingcart.persist.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

	public List<ProductEntity> findByCategoryId(Integer categoryId);
}
