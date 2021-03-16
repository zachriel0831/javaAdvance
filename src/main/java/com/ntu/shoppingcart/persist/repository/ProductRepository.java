package com.ntu.shoppingcart.persist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ntu.shoppingcart.persist.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

	public List<ProductEntity> findByCategoryId(Integer categoryId);

	@Query("select p from ProductEntity p where p.status =?1  ")
	public List<ProductEntity> selectAllProduct(String status);

}
