package com.myapp.spring.dto;

import java.util.ArrayList;
import java.util.List;

import com.myapp.spring.entity.Cart;
import com.myapp.spring.entity.Item;

public class CartDTO {

    private String name;
    private String details;
    private int fullPrice;
    private String date;
    private List<ItemDTO> items;

    public CartDTO() {

    }
    public CartDTO(Cart cart) {

        this.date = cart.getDate();
        this.name = cart.getName();
        this.details = cart.getDetails();
        this.fullPrice = cart.getFullPrice();
        this.items = ItemDTO.getItemDTOList(cart.getItems());
    }
    


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getFullPrice() {
        return fullPrice;
    }

	public List<ItemDTO> getItems() {
		return items;
	}
	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setFullPrice(int fullPrice) {
        this.fullPrice = fullPrice;
    }

    public String getDate() {
        return date;
    }
}