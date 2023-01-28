package com.myapp.spring.dto;

import com.myapp.spring.entity.Cart;

public class ShowOrderDTO {
	private Cart cart;
	public Cart getCart() {
		
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
}
