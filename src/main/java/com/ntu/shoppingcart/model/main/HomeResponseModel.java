package com.ntu.shoppingcart.model.main;

import com.ntu.shoppingcart.model.common.BaseResponseModel;
import com.ntu.shoppingcart.model.common.Product;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper=false)
public class HomeResponseModel extends BaseResponseModel{

	private Product products;
}
