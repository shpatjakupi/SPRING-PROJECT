package com.myapp.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.spring.dao.ItemDAO;
import com.myapp.spring.entity.Item;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDAO itemDAO;
	
	
	@Override
	@Transactional
	public List<Item> getItems() {
		
		return itemDAO.getItems();
		
	}

	@Override
	@Transactional
	public void saveItem(Item item) {
		itemDAO.saveItem(item);
	}

	@Override
	@Transactional
	public Item getItem(int itemId) {
		return itemDAO.getItem(itemId);
	}

}
