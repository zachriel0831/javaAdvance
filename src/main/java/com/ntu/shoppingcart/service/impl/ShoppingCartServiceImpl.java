package com.ntu.shoppingcart.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.ntu.shoppingcart.model.ShoppingCartDetail;
import com.ntu.shoppingcart.model.User;
import com.ntu.shoppingcart.persist.entity.ProductEntity;
import com.ntu.shoppingcart.persist.entity.ShoppingCartEntity;
import com.ntu.shoppingcart.persist.repository.ProductRepository;
import com.ntu.shoppingcart.persist.repository.ShoppingCartRepository;
import com.ntu.shoppingcart.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	private static final String STOCK_Y = "有庫存";
	private static final String STOCK_N = "沒有庫存";
	

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Integer findTotalCount(User user) {
		return shoppingCartRepository.findTotalCount(user.getUserId());
	}

	@Override
	public void add(User user, Integer productId, Integer count) {

		ShoppingCartEntity entity = Optional
				.ofNullable(shoppingCartRepository.findByUserIdAndProductId(user.getUserId(), productId)).orElse(new ShoppingCartEntity());

		ShoppingCartEntity shoppingCartEntity = new ShoppingCartEntity();
		
		if (!ObjectUtils.isEmpty(entity.getId())) {
			shoppingCartEntity.setId(entity.getId());
		}
		Integer nowCount = entity.getCount() == null ? 0 : entity.getCount();
		shoppingCartEntity.setCount(nowCount + count);
		shoppingCartEntity.setUserId(user.getUserId());
		shoppingCartEntity.setProductId(productId);
		
		shoppingCartRepository.save(shoppingCartEntity);
	}

	@Override
	public List<ShoppingCartDetail> findMyCartList(User user) {
		List<ShoppingCartDetail> result = new ArrayList<>();
		
		List<ShoppingCartEntity> shoppingCartEntities = shoppingCartRepository.findAllByUserId(user.getUserId());
		
		if(shoppingCartEntities.size() > 0) {
			shoppingCartEntities.stream().forEach(m -> {
				Optional<ProductEntity> op = productRepository.findById(m.getProductId());
				ProductEntity p = op.get();
				ShoppingCartDetail cartDetail = new ShoppingCartDetail();
				cartDetail.setProductId(m.getProductId());
				cartDetail.setImg(p.getImageDir());
				cartDetail.setName(p.getProductName());
				cartDetail.setInStock(Integer.parseInt(p.getProductStock()) > 0 ? STOCK_Y: STOCK_N);
				cartDetail.setPrice(new BigDecimal(m.getCount()).multiply(new BigDecimal(p.getProductPrice())));
				cartDetail.setStock(m.getCount());
				result.add(cartDetail);
			});
		}
		
		return result;
	}

	@Override
	public BigDecimal getTotal(List<ShoppingCartDetail> myCartList) {
		if(myCartList.size() <= 0 ) {
			return new BigDecimal("0");
		}
		BigDecimal total = myCartList.stream().map(ShoppingCartDetail::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
		return total;
	}

	@Override
	public BigDecimal getSubTotal(Integer productId, Integer count) {
		return null;
	}

}
