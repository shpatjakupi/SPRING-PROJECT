package com.myapp.spring.entity;

import java.util.List;

public class ShopRequest {
	
	Cart cart;
	List<Order> orders;
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "fullRepo [cart=" + cart + ", orders=" + orders + "]";
	}


}
