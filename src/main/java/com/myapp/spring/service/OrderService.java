package com.myapp.spring.service;

import java.util.List;

import com.myapp.spring.entity.Order;

public interface OrderService {
	public List<Order> getOrders();

	public void saveOrder(Order Order);

	public Order getOrder(int orderId);

}
