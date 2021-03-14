package com.ntu.shoppingcart.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ntu.shoppingcart.model.User;

@Controller
@RequestMapping("/u")
public class UserController extends BaseController {

	
	@Secured("user")
	@GetMapping("/page")
	public String loginPage(Model model) {

		User user = getLoginUser();
		

		return "";
	}
	
}
