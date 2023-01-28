package com.myapp.spring.dao;

import java.util.List;

import com.myapp.spring.dto.CartDTO;
import com.myapp.spring.dto.ItemDTO;

public interface CustomerDAO {
	public void saveOrder(CartDTO cartDTO, List<ItemDTO> items);
}
