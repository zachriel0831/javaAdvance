package com.ntu.shoppingcart.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.ntu.shoppingcart.model.Product;
import com.ntu.shoppingcart.persist.entity.ProductEntity;
import com.ntu.shoppingcart.persist.repository.ProductRepository;
import com.ntu.shoppingcart.service.ProductService;
import org.dozer.DozerBeanMapper;
import com.ntu.shoppingcart.util.NumberUtils;

@Service
public class ProductServiceImpl implements ProductService {

	private final static String SHOPPING_CART_URI = "/shopping/cart/add/";

	private final static String PRODUCT_STATUS_ON = "1";
	private final static String PRODUCT_STATUS_OFF = "0";

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> findProductsByCategory(String categoryId) {

		if (ObjectUtils.isEmpty(categoryId) || NumberUtils.isNotNumeric(categoryId)) {
			return new ArrayList<>();
		}

		List<ProductEntity> products = productRepository.findByCategoryId(Integer.parseInt(categoryId));
		return products.stream()
				.map(m -> new Product(m.getProductId(), m.getCategoryId(), m.getProductName(),
						SHOPPING_CART_URI + m.getProductId(), m.getProductPrice(), m.getProductStock(),
						m.getDescription(), m.getCreateTime(), m.getUpdateTime(), m.getPreviousUpdateTime(),
						m.getImageDir()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Product> addNewProduct(Product product) {
		DozerBeanMapper mapper = new DozerBeanMapper();
		Date currentTime = new Date(System.currentTimeMillis());
		ProductEntity productEntity = mapper.map(product, ProductEntity.class);
		productEntity.setCreateTime(currentTime);
		productEntity.setUpdateTime(currentTime);
		productEntity.setPreviousUpdateTime(currentTime);
		productEntity.setStatus(PRODUCT_STATUS_ON);

		productRepository.save(productEntity);

		return selectAllProduct();
	}

	@Override
	public List<Product> deleteProducts(List<Integer> productIds) {
		Date currentTime = new Date(System.currentTimeMillis());

		for (int id : productIds) {

			Optional<ProductEntity> productEntityOptional = productRepository.findById(id);

			productEntityOptional.ifPresent(productEntity -> {
				productEntity.setUpdateTime(currentTime);
				productEntity.setPreviousUpdateTime(currentTime);
				productEntity.setStatus(PRODUCT_STATUS_OFF);

				productRepository.save(productEntity);

			});
		}

		return selectAllProduct();
	}

	@Override
	public List<Product> updateProduct(Product product) {
		DozerBeanMapper mapper = new DozerBeanMapper();
		Date currentTime = new Date(System.currentTimeMillis());
		ProductEntity productEntity = mapper.map(product, ProductEntity.class);
		productEntity.setCreateTime(currentTime);
		productEntity.setUpdateTime(currentTime);
		productEntity.setPreviousUpdateTime(currentTime);
		productEntity.setStatus(PRODUCT_STATUS_ON);

		productRepository.save(productEntity);

		return selectAllProduct();
	}
	
	@Override
	public List<Product> selectAllProduct() {

		List<ProductEntity> results = productRepository.selectAllProduct("1");
		List<Product> productResult = results.stream()
				.map(m -> new Product(m.getProductId(), m.getCategoryId(), m.getProductName(),
						SHOPPING_CART_URI + m.getProductId(), m.getProductPrice(), m.getProductStock(),
						m.getDescription(), m.getCreateTime(), m.getUpdateTime(), m.getPreviousUpdateTime(),
						m.getImageDir()))
				.collect(Collectors.toList());
		return productResult;
	}
}
