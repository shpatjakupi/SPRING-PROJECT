package com.myapp.spring.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.myapp.spring.entity.Cart;
import com.myapp.spring.entity.Item;

public class ParseOrderDTO {
	
  
    private Cart cart;

    
    private List<Item> items;
	
	public ParseOrderDTO() {
	
	}	
	public Cart getCart() {
	
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "fullRepo [cart=" + cart + ", orders=" + items + "]";
	}


}
