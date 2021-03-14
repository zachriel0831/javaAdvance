package com.ntu.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ntu.shoppingcart.model.common.Product;
import com.ntu.shoppingcart.service.impl.ProductServiceImpl;
import com.ntu.shoppingcart.model.ProductCataLog;
import com.ntu.shoppingcart.service.IndexService;

@Controller
@RequestMapping("/index")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class IndexController {
	
	@Autowired
	private IndexService indexService;
	
	
	/**
	 * 首頁
	 * @return
	 */
	@GetMapping
	public String index(Model model) {
		List<ProductCataLog> productCataLogs = indexService.findProductCataLogs();
		model.addAttribute("productCataLogs", productCataLogs);
		return "index";
	}
	
	
	/**
	 * 登入頁
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/login")
	public String loginPage(Model model) {
		return "login";
	}

}
