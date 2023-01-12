package com.myapp.spring.dao;

import java.util.List;

import com.myapp.spring.entity.Order;

public interface OrderDAO {
	public List<Order> getOrders();

	public void saveOrder(Order Order);

	public Order getOrder(int orderId);
}
