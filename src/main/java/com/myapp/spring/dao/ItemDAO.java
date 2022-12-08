package com.myapp.spring.dao;

import java.util.List;

import com.myapp.spring.entity.Customer;
import com.myapp.spring.entity.Item;

public interface ItemDAO {
	public List<Item> getItems();

	public void addItem(Item item);

	public Item getItem(int theId);

	public void deleteItem(int theId);

}
