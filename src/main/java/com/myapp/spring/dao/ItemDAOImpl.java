package com.myapp.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.myapp.spring.entity.Customer;
import com.myapp.spring.entity.Item;

public class ItemDAOImpl implements ItemDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Item> getItems() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Item> theQuery = 
				currentSession.createQuery("from item order by lastName",
											Item.class);
		
		// execute query and get result list
		List<Item> items = theQuery.getResultList();
				
		// return the results		
		return items;
	}

	@Override
	public void addItem(Item item) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
	
		currentSession.saveOrUpdate(item);

	}

	@Override
	public Item getItem(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Item theItem = currentSession.get(Item.class, theId);
		
		return theItem;
	}

	@Override
	public void deleteItem(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from item where id=:itemId");
		theQuery.setParameter("itemId", theId);
		
		theQuery.executeUpdate();		

	}

}
