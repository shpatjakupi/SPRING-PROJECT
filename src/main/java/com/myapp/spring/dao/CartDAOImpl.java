package com.myapp.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myapp.spring.entity.Cart;
import com.myapp.spring.entity.Order;

@Repository
public class CartDAOImpl implements CartDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Cart> getCarts() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Cart> theQuery = 
				currentSession.createQuery("from Cart",
											Cart.class);
		
		// execute query and get result list
		List<Cart> carts = theQuery.getResultList();
		// return the results		
		return carts;
	}

	@Override
	public void saveCart(Cart cart) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(cart);

	}

	@Override
	public Cart getCart(int cartId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Cart cart = currentSession.get(Cart.class, cartId);
		
		return cart;
	}

}
