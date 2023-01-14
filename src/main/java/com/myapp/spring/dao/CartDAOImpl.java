package com.myapp.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.spring.config.DemoAppConfig;
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
	
	@Override
	public Cart getNewCart() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Cart> newOrder = currentSession.createQuery("from Cart c where c.id = (select max(c2.id) from Cart c2)",Cart.class);
		Query<Cart> oldOrder = currentSession.createQuery("from Cart c where c.id = (select max(c2.id - 1) from Cart c2)",Cart.class);
		Cart newCart = newOrder.getSingleResult();
		Cart oldCart = oldOrder.getSingleResult();
		if(newCart.getId() < oldCart.getId()) {
			return newCart;
		}
		else {
			return null;
		}
		
	}

}
