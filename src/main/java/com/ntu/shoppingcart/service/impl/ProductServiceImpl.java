package com.ntu.shoppingcart.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntu.shoppingcart.model.Product;
import com.ntu.shoppingcart.persist.entity.ProductEntity;
import com.ntu.shoppingcart.persist.repository.ProductRepository;
import com.ntu.shoppingcart.service.ProductService;
import org.dozer.DozerBeanMapper;

@Service
public class ProductServiceImpl implements ProductService {
	
	
	@Autowired
	ProductRepository productRepository;

	public List<Product> addNewProduct(Product product) {
		
		DozerBeanMapper mapper = new DozerBeanMapper();
		ProductEntity productEntity = mapper.map(product, ProductEntity.class);
		productEntity.setCreateTime(new Date(System.currentTimeMillis()));
		productEntity.setUpdateTime(new Date(System.currentTimeMillis()));
		productEntity.setPreviousUpdateTime(new Date(System.currentTimeMillis()));

		productRepository.save(productEntity);
		List<Product> results = new ArrayList<Product>();

		return results;
	}
}
