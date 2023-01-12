package com.myapp.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.entity.Cart;
import com.myapp.spring.entity.Order;
import com.myapp.spring.service.CartService;
import com.myapp.spring.service.OrderService;

@RestController
@RequestMapping("/order-app")
public class AppRestController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderService orderService;
	

	@GetMapping("/carts")
	public List<Cart> getCarts() {
		
		return cartService.getCarts();
		
	}
	
	@PostMapping("/addCart")
	public Cart addItem(@RequestBody Cart cart) {
		
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		
		cart.setId(0);
		
		cartService.saveCart(cart);
		
		int cartId = cart.getId();
		
		Order order = new Order();
		order.setCartId(cartId);
		
		orderService.saveOrder(order);
		
		return cart;
	}
	
	@GetMapping("/getCart/{cartId}")
	public Cart addItem(@PathVariable int cartId) {
		
	
		Cart cart = cartService.getCart(cartId);
		
		return cart;
	}
	
//	@PostMapping("/sendOrder")
//	public Order sendOrder(@RequestBody Order order) {	
//		
//		order.setId(0);
//		
//		orderService.saveOrder(order);
//		
//		return order;
//	}
	
	
}
