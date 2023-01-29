package com.myapp.spring.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myapp.spring.dto.CartDTO;
import com.myapp.spring.entity.Cart;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<CartDTO> getOrdersFromToday() {
	    Session currentSession = sessionFactory.getCurrentSession();
	    Query<Cart> theQuery = currentSession.createQuery("from Cart c where date(c.orderedDate) = CURDATE() or date(c.pickUpDate) = CURDATE() and c.preOrder = 1", Cart.class);
	    
	    List<Cart> carts = theQuery.getResultList();
	    List<CartDTO> cartDTOs = new ArrayList<>();
	    LocalDateTime now = LocalDateTime.now();
	    
	    for (Cart cart : carts) {
	    	String pickUpDate = cart.getPickUpDate();
	        int index = pickUpDate.indexOf(".");
	
	        if (index != -1) {
	            pickUpDate = pickUpDate.substring(0, index);
	        }
	    	LocalDateTime pickUpDateTime = LocalDateTime.parse(pickUpDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	    	
	    	if(cart.isPreOrder() && pickUpDateTime.toLocalDate().equals(now.toLocalDate())) {
	    		cartDTOs.add(new CartDTO(cart));
	    	}
	    	else {
	            cartDTOs.add(new CartDTO(cart));
	        }
	    }

	    return cartDTOs;
	}

}