package com.myapp.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.myapp.spring.dao.CustomerDAO;
import com.myapp.spring.dao.ItemDAO;
import com.myapp.spring.entity.Item;

public class ItemServiceImpl implements ItemService {

		
	@Autowired
	private ItemDAO itemDAO;
	
	@Override
	public List<Item> getItems() {
		return itemDAO.getItems();
	}

	@Override
	public void addItem(Item item) {
		
		itemDAO.addItem(item);
	}

	@Override
	public Item getItem(int theId) {
	
		return itemDAO.getItem(theId);
	}

	@Override
	public void deleteItem(int theId) {
		
		itemDAO.deleteItem(theId);
	}

}
