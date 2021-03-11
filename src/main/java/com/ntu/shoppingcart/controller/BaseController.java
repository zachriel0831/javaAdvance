package com.ntu.shoppingcart.controller;

import org.springframework.security.core.context.SecurityContextHolder;

import com.ntu.shoppingcart.model.User;

public class BaseController {

	
	
	/**
	 * 取得登入User
	 * @return
	 */
	protected User getLoginUser() {
		User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		return loginUser;
	}
}
