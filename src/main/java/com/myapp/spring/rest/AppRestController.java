package com.myapp.spring.rest;

import java.util.ArrayList;
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

import com.myapp.spring.dto.ShowOrderDTO;
import com.myapp.spring.dto.ParseOrderDTO;
import com.myapp.spring.entity.Cart;
import com.myapp.spring.entity.Item;
import com.myapp.spring.service.AdminService;
import com.myapp.spring.service.CartService;
import com.myapp.spring.service.ItemService;

@RestController
@RequestMapping("/order-app")
public class AppRestController {
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ItemService orderService;
		
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/sendOrder") 
	public ResponseEntity<String> addItem(@RequestBody ParseOrderDTO req) {
		Cart cart = req.getCart();
		
		cartService.saveCart(cart);
		for (Item item : req.getItems()) {
			item.setCart(cart);
            orderService.saveItem(item);
		}
	 
	    
		
		return new ResponseEntity<>("The shop has got the order!", HttpStatus.OK);

	}

	@GetMapping("/getTodaysOrders") // fetch every minute in ReactJS
	public ResponseEntity<List <ShowOrderDTO>>  test() {
		List<ShowOrderDTO> todaysOrderList = new ArrayList();
			
		List<Cart> fullOrder = adminService.getFullOrder();
		
		for(Cart cart : fullOrder) {
			ShowOrderDTO orderDTO = new ShowOrderDTO();
			orderDTO.setCart(cart);
			todaysOrderList.add(orderDTO);
		}
		
		return new ResponseEntity<>(todaysOrderList, HttpStatus.OK);
	}
	
	
	
	
	//customer react page should show the 
	
}
