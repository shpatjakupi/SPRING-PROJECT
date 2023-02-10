package com.myapp.spring.entity;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="Order")
@javax.persistence.Table(name = "`Order`")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Details")
	private String details;
	
	@Column(name="Full_price")
	private int fullPrice;
	
	@Column(name="Ordered_date")
	private String orderedDate;
	
	@Column(name="Pick_up_date")
	private String pickUpDate;
	
	@OneToMany(mappedBy = "order")
	private List<Item> items;
	
	@Column(name = "Pre_order")
	private boolean preOrder;
	
	@Column(name = "Order_done")
	private boolean orderDone;
	
	public List<Item> getItems() {
	        return items;
	    }

	public String getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(String orderedDate) {
		this.orderedDate = orderedDate;
	}

	public Order() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public boolean isPreOrder() {
		return preOrder;
	}

	public void setPreOrder(boolean preOrder) {
		this.preOrder = preOrder;
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

	public void setFullPrice(int fullPrice) {
		this.fullPrice = fullPrice;
	}

	public boolean isOrderDone() {
		return orderDone;
	}

	public void setOrderDone(boolean orderDone) {
		this.orderDone = orderDone;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", details=" + details + ", fullPrice=" + fullPrice
				+ ", orderedDate=" + orderedDate + ", pickUpDate=" + pickUpDate + ", items=" + items + ", preOrder="
				+ preOrder + ", orderDone=" + orderDone + "]";
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getPickUpDate() {
		return pickUpDate;
	}

	public void setPickUpDate(String pickUpDate) {
		this.pickUpDate = pickUpDate;
	}




	
	

}