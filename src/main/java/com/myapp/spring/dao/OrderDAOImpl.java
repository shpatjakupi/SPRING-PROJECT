package com.myapp.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myapp.spring.entity.Order;

@Repository
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Order> getOrders() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query  ... sort by last name
		Query<Order> theQuery = 
				currentSession.createQuery("from Order",
											Order.class);
		
		// execute query and get result list
		List<Order> orders = theQuery.getResultList();
		// return the results		
		return orders;
	}

	@Override
	public void saveOrder(Order Order) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally 
		currentSession.saveOrUpdate(Order);

	}

	@Override
	public Order getOrder(int orderId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Order order = currentSession.get(Order.class, orderId);
		
		return order;
	}

}
