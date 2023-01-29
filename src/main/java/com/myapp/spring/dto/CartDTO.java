package com.myapp.spring.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.myapp.spring.entity.Cart;


public class CartDTO {

    private String name;
    private String details;
    private int fullPrice;
    private String orderedDate;
    private String pickUpDate;
    private boolean preOrder;
    private List<ItemDTO> items;

    public CartDTO() {

    }
    public CartDTO(Cart cart) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date orderedDateAsDate = formatter.parse(cart.getOrderedDate());
            Date pickUpDateAsDate = formatter.parse(cart.getPickUpDate());
            this.orderedDate = formatDate(orderedDateAsDate);
            this.pickUpDate = formatDate(pickUpDateAsDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.preOrder = cart.isPreOrder();
        this.name = cart.getName();
        this.details = cart.getDetails();
        this.fullPrice = cart.getFullPrice();
        this.items = ItemDTO.getItemDTOList(cart.getItems());
    }

    public String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = formatter.format(date);
        return formattedDate;
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

	public boolean isPreOrder() {
		return preOrder;
	}
	public void setPreOrder(boolean preOrder) {
		this.preOrder = preOrder;
	}
	public List<ItemDTO> getItems() {
		return items;
	}
	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}
	public String getOrderedDate() {
		return orderedDate;
	}
	public void setOrderedDate(String orderedDate) {
		this.orderedDate = orderedDate;
	}
	public String getPickUpDate() {
		return pickUpDate;
	}
	public void setPickUpDate(String pickUpDate) {
		this.pickUpDate = pickUpDate;
	}
	public void setFullPrice(int fullPrice) {
        this.fullPrice = fullPrice;
    }

  
}