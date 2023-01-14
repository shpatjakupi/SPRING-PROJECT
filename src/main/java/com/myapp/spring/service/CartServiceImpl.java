package com.myapp.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.spring.dao.CartDAO;
import com.myapp.spring.entity.Cart;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDAO cartDAO;
	
	
	@Override
	@Transactional
	public List<Cart> getCarts() {
		return cartDAO.getCarts();
	}

	@Override
	@Transactional
	public void saveCart(Cart cart) {
		cartDAO.saveCart(cart);

	}

	@Override
	@Transactional
	public Cart getCart(int cartId) {
		return cartDAO.getCart(cartId);
	}
	
	@Override
	@Transactional
	public Cart getNewCart() {
		 return cartDAO.getNewCart();
	}

}
