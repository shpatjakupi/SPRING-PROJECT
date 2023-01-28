package com.myapp.spring.dao;

import java.util.List;

import com.myapp.spring.entity.Item;

public interface ItemDAO {
	public List<Item> getItems();

	public void saveItem(Item item);

	public Item getItem(int orderId);
}
