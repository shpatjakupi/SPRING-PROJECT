package com.myapp.spring.service;

import java.util.List;

import com.myapp.spring.dto.CartDTO;
import com.myapp.spring.dto.ItemDTO;

public interface CustomerService {
	public void saveOrder(CartDTO cartDTO, List<ItemDTO> items);
}
