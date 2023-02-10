package com.myapp.spring.service;

import java.util.List;

import com.myapp.spring.dto.OrderDTO;
import com.myapp.spring.dto.ItemDTO;

public interface CustomerService {
	public void saveOrder(OrderDTO orderDTO, List<ItemDTO> items);
	
}
