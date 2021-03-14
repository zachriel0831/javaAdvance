package com.ntu.shoppingcart.persist.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ntu.shoppingcart.persist.entity.ProductCategoryEntity;

public interface ProductCategoryRepository extends PagingAndSortingRepository<ProductCategoryEntity, Integer> {

}
