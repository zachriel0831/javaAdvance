package com.ntu.shoppingcart.models.home;

import com.ntu.shoppingcart.models.common.BaseResponseModel;
import com.ntu.shoppingcart.models.common.Products;
import com.ntu.shoppingcart.models.common.Users;

import lombok.Data;


@Data
public class HomeResponseModel extends BaseResponseModel{

	private Products products;
}
