package com.myapp.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.spring.dao.OrderDAO;
import com.myapp.spring.entity.Order;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;
	
	
	@Override
	@Transactional
	public List<Order> getOrders() {
		
		return orderDAO.getOrders();
		
	}

	@Override
	@Transactional
	public void saveOrder(Order Order) {
		orderDAO.saveOrder(Order);
	}

	@Override
	@Transactional
	public Order getOrder(int orderId) {
		return orderDAO.getOrder(orderId);
	}

}
