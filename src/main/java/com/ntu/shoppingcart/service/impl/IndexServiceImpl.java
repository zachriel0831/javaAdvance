package com.ntu.shoppingcart.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ntu.shoppingcart.model.ProductCataLog;
import com.ntu.shoppingcart.persist.entity.ProductCategoryEntity;
import com.ntu.shoppingcart.persist.repository.ProductCategoryRepository;
import com.ntu.shoppingcart.service.IndexService;

@Service
public class IndexServiceImpl implements IndexService {
	
	private static final String PATH = "/product/catalog/";

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Override
	public List<ProductCataLog> findProductCataLogs() {
		
		Pageable pageable = PageRequest.of(0, 6, Sort.by("orderNumber").ascending());
		
		Page<ProductCategoryEntity> productCataLogs = productCategoryRepository.findAll(pageable);

		return productCataLogs.stream()
				.map(m -> new ProductCataLog( m.getImageDir(), m.getCategoryName(), getPath(m.getCategoryId())))
				.collect(Collectors.toList());
	}

	
	private String getPath(Integer id) {
		return PATH + Integer.toString(id);
	}
}
