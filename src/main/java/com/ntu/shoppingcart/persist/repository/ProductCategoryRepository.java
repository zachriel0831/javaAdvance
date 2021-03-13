package com.ntu.shoppingcart.persist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntu.shoppingcart.persist.entity.ProductCategoryEntity;

public interface ProductCategoryRepository extends JpaRepository<ProductCategoryEntity, Integer> {

}
