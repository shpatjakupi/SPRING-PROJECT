package com.myapp.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.entity.Cart;
import com.myapp.spring.entity.Order;
import com.myapp.spring.entity.ShopRequest;
import com.myapp.spring.service.CartService;
import com.myapp.spring.service.OrderService;

@RestController
@RequestMapping("/order-app")
public class AppRestController {
	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderService orderService;
	
	
	@PostMapping("/sendOrder")
	public ResponseEntity<String> addItem(@RequestBody ShopRequest req) {
		Cart cart = req.getCart();
		
		cart.setId(0);
		cartService.saveCart(cart);
		int cartId = cart.getId();
		List<Order> orders = req .getOrders();
		for(Order order : orders) {
			order.setCartId(cartId);
			orderService.saveOrder(order);
		}
//		System.out.println("Order name: "+cart.getName()+" Order details: " + cart.getDetails() + " Order price: " + cart.getFullPrice());
//		for(Order order : orders) {
//			System.out.println("The items that have been orderd: " + order.getDetails());
//		}
		//Call waitTime api 
	    
		
		return new ResponseEntity<>("The shop has got the order!", HttpStatus.OK);

	}
	

	@GetMapping("/getNewOrder") // fetch every minute in ReactJS
	public ResponseEntity<Cart> test() {
		
		Cart cart = cartService.getNewCart();
		
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}
	
	
	
	
	//customer react page should show the 
	
}
