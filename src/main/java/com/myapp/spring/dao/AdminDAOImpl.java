package com.myapp.spring.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myapp.spring.entity.Cart;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Cart> getFullOrder() {
		Session currentSession = sessionFactory.getCurrentSession();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = formatter.format(new Date());
        Query<Cart> theQuery = currentSession.createQuery("from Cart c where c.date = :currentDate",Cart.class); // 
		theQuery.setParameter("currentDate", currentDate);
		
	    List<Cart> carts = theQuery.getResultList();
	    
	    return carts;
	}

}
