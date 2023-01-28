package com.myapp.spring.dto;

import com.myapp.spring.entity.Cart;

public class ShowOrderDTO {
	private CartDTO cart;
	
	public CartDTO getCart() {
		
		return cart;
	}
	public void setCart(CartDTO cart) {
		this.cart = cart;
	}
}
