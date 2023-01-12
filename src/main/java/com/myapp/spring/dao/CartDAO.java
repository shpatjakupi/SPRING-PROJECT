package com.myapp.spring.dao;

import java.util.List;

import com.myapp.spring.entity.Cart;


public interface CartDAO {
	public List<Cart> getCarts();

	public void saveCart(Cart cart);

	public Cart getCart(int cartId);

}
