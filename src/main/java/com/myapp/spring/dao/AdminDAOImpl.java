package com.myapp.spring.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myapp.spring.dto.OrderDTO;
import com.myapp.spring.entity.Order;
import com.myapp.spring.utils.DateUtil;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<OrderDTO> getOrdersFromToday() {
	    Session currentSession = sessionFactory.getCurrentSession();
	    Query<Order> theQuery = currentSession.createQuery("from Order o where date(o.orderedDate) = CURDATE() or date(o.pickUpDate) = CURDATE() and o.preOrder = 1", Order.class);

	    
	    List<Order> orders = theQuery.getResultList();
	    List<OrderDTO> orderDTOs = new ArrayList<>();
	    LocalDateTime now = LocalDateTime.now();
	    
	    for (Order order : orders) {
	    	String pickUpDate = order.getPickUpDate();
	        int index = pickUpDate.indexOf(".");
	
	        if (index != -1) {
	            pickUpDate = pickUpDate.substring(0, index);
	        }
	    	LocalDateTime pickUpDateTime = LocalDateTime.parse(pickUpDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	    	
	    	if(order.isPreOrder() && pickUpDateTime.toLocalDate().equals(now.toLocalDate())) {
	    		orderDTOs.add(new OrderDTO(order));
	    	}    		
        	else {
	            orderDTOs.add(new OrderDTO(order));
	        }
	    }

	    return orderDTOs;
	}
	
	@Override
	public List<OrderDTO> getOrderByDate(String dateKey) {
	    Session currentSession = sessionFactory.getCurrentSession();
	    DateUtil util = new DateUtil();
	    ArrayList<Date> theList = util.getArrayOfDates(dateKey);

	    if (theList.isEmpty()) {
	        throw new IllegalArgumentException("No dates were found for the date key: " + dateKey);
	    }

	    Date firstDate = theList.get(0);
	    Query<Order> theQuery;

	    if (theList.size() == 1) {
	        theQuery = currentSession.createQuery("from Order where DATE(pickUpDate) = :currentDate order by pickUpDate desc", Order.class);
	        theQuery.setParameter("currentDate", firstDate);
	    } else {
	        Date lastDate = theList.get(1);
	        theQuery = currentSession.createQuery("from Order where DATE(pickUpDate) BETWEEN :firstDate and :lastDate order by pickUpDate desc", Order.class);
	        theQuery.setParameter("firstDate", firstDate);
	        theQuery.setParameter("lastDate", lastDate);
	    }

	    List<Order> orders = theQuery.getResultList();
	    List<OrderDTO> orderDTOs = new ArrayList<>();
		for(Order order : orders) {
			orderDTOs.add(new OrderDTO(order));
		}
	    return orderDTOs;
	}
	
	@Override
	public void setOrderToDone(int orderId) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Order> theQuery = currentSession.
				createQuery("from Order where id=:orderId", Order.class);
		theQuery.setParameter("orderId", orderId);
		
		Order order = theQuery.getSingleResult();
		System.out.println("order ? " + order.toString());
		order.setOrderDone(true);
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(order);
		
	}
	
	

}