package com.myapp.spring.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.myapp.spring.entity.Cart;
import com.myapp.spring.entity.Item;

public class ParseOrderDTO {
	
  
    private CartDTO cart;

    
    private List<ItemDTO> items;
	
	public ParseOrderDTO() {
	
	}	
	public CartDTO getCart() {
	
		return cart;
	}
	public void setCart(CartDTO cart) {
		this.cart = cart;
	}
	public List<ItemDTO> getItems() {
		return items;
	}
	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "fullRepo [cart=" + cart + ", orders=" + items + "]";
	}


}
