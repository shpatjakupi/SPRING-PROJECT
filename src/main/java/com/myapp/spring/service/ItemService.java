package com.myapp.spring.service;

import java.util.List;

import com.myapp.spring.entity.Item;

public interface ItemService {
	public List<Item> getItems();

	public void addItem(Item item);

	public Item getItem(int theId);

	public void deleteItem(int theId);

}
