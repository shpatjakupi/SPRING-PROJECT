package com.myapp.spring.dao;

import java.util.List;

import com.myapp.spring.dto.OrderDTO;
import com.myapp.spring.dto.ItemDTO;

public interface CustomerDAO {
	public void saveOrder(OrderDTO orderDTO, List<ItemDTO> items);
	
}
