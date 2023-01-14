package com.myapp.spring.service;

import java.util.List;

import com.myapp.spring.entity.Cart;

public interface CartService {
	public List<Cart> getCarts();

	public void saveCart(Cart cart);

	public Cart getCart(int cartId);
	

	public Cart getNewCart();
}
