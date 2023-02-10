package com.myapp.spring.dao;

import java.util.List;

import com.myapp.spring.dto.OrderDTO;

public interface AdminDAO {
	public List<OrderDTO> getOrdersFromToday();
	public List<OrderDTO> getOrderByDate(String dateKey);
	public void setOrderToDone(int orderId);
}
