package com.myapp.spring.service;

import java.util.List;

import com.myapp.spring.entity.Item;

public interface ItemService {
	public List<Item> getItems();

	public void saveItem(Item item);

	public Item getItem(int itemId);

}
