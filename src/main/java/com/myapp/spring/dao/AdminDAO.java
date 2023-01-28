package com.myapp.spring.dao;

import java.util.List;

import com.myapp.spring.dto.CartDTO;
import com.myapp.spring.entity.Cart;


public interface AdminDAO {
	public List<CartDTO> getFullOrder();
}
