package com.myapp.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.entity.Cart;
import com.myapp.spring.service.CartService;

@RestController
@RequestMapping("/order-app")
public class AppRestController {

	@Autowired
	private CartService cartService;

	// add mapping for GET /item
	@GetMapping("/carts")
	public List<Cart> getCarts() {
		
		return cartService.getCarts();
		
	}
}
