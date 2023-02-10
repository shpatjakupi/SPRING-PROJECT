package com.myapp.spring.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.myapp.spring.entity.Order;


public class OrderDTO {
 
	private int id;
    private String name;
    private String details;
    private int fullPrice;
    private String orderedDate;
    private String pickUpDate;
    private boolean preOrder;
    private boolean orderDone;
    private List<ItemDTO> items;

    public OrderDTO() {

    }
    public OrderDTO(Order order) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date orderedDateAsDate = formatter.parse(order.getOrderedDate());
            Date pickUpDateAsDate = formatter.parse(order.getPickUpDate());
            this.orderedDate = formatDate(orderedDateAsDate);
            this.pickUpDate = formatDate(pickUpDateAsDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.preOrder = order.isPreOrder();
        this.orderDone = order.isOrderDone();
        this.name = order.getName();
        this.details = order.getDetails();
        this.fullPrice = order.getFullPrice();
        this.items = ItemDTO.getItemDTOList(order.getItems());
        this.id = order.getId();
    }

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = formatter.format(date);
        return formattedDate;
    }
    public boolean isOrderDone() {
		return orderDone;
	}
	public void setOrderDone(boolean orderDone) {
		this.orderDone = orderDone;
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