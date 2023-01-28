package com.myapp.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myapp.spring.entity.Item;

@Repository
public class ItemDAOImpl implements ItemDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Item> getItems() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query  ... sort by last name
		Query<Item> theQuery = 
				currentSession.createQuery("from Item",
											Item.class);
		
		// execute query and get result list
		List<Item> items = theQuery.getResultList();
		// return the results		
		return items;
	}

	@Override
	public void saveItem(Item item) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally 
		currentSession.saveOrUpdate(item);

	}

	@Override
	public Item getItem(int itemId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Item item = currentSession.get(Item.class, itemId);
		
		return item;
	}

}
