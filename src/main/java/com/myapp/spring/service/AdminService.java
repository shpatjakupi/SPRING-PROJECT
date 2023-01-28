package com.myapp.spring.service;

import java.util.List;

import com.myapp.spring.entity.Cart;

public interface AdminService {
	public List<Cart> getFullOrder();
}
