package com.myapp.spring.service;

import java.util.List;

import com.myapp.spring.dto.OrderDTO;

public interface AdminService {
	public List<OrderDTO> getOrdersFromToday();
	public List<OrderDTO> getOrderByDate(String dateKey);
	public void setOrderToDone(int orderId);
}
