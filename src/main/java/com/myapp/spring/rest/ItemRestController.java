//package com.myapp.spring.rest;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.myapp.spring.entity.Item;
//import com.myapp.spring.entity.Toppings;
//import com.myapp.spring.service.ItemService;
//import com.myapp.spring.service.ToppingsService;
//
//@RestController
//@RequestMapping("/menu")
//public class ItemRestController {
//	@Autowired
//	private ItemService itemService;
//	
//	@Autowired
//	private ToppingsService toppingsService;
//
//
//
//	
//	// add mapping for GET /item
//	@GetMapping("/items")
//	public List<Item> getItems() {
//		
//		return itemService.getItems();
//		
//	}
//	
//	
////	// add mapping for POST /  - add new item
//	
//	@PostMapping("/new")
//	public Item addItem(@RequestBody Item item) {
//		
//		// also just in case the pass an id in JSON ... set id to 0
//		// this is force a save of new item ... instead of update
//		
//		item.setId(0);
//		
//		itemService.addItem(item);
//		
//		return item;
//	}
//	
//	@PostMapping("/new/topping")
//	public Toppings addTopping(@RequestBody Toppings topping) {
//		
//		// also just in case the pass an id in JSON ... set id to 0
//		// this is force a save of new item ... instead of update
//		Item item = itemService.getItem(1);
//		
//		item.add(topping);
//		toppingsService.saveTopping(topping);
//		
//		return topping;
//	}
//
//	// add mapping for PUT / - update existing item
//	
//	@PutMapping("/update")
//	public Item updateItem(@RequestBody Item theItem) {
//		
//		itemService.addItem(theItem);
//		
//		return theItem;
//		
//	}
//	
//	@DeleteMapping("/delete/{itemId}")
//	public String deleteItem(@PathVariable int itemId) {
//		
//		Item tempItem = itemService.getItem(itemId);
//		
//		// throw exception if null
//		
//		if (tempItem == null) {
//			//throw new CustomerNotFoundException("Customer id not found - " + itemId);
//		}
//				
//		itemService.deleteItem(itemId);
//		
//		return "Deleted customer id - " + itemId;
//	}
//	
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
