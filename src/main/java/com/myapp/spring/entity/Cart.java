package com.myapp.spring.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Cart")
public class Cart {
	
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
	
	@OneToMany(mappedBy = "cart")
	private List<Item> items;
	
	@Column(name = "Pre_order")
	private boolean preOrder;
	
	public List<Item> getItems() {
	        return items;
	    }

	public String getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(String orderedDate) {
		this.orderedDate = orderedDate;
	}

	public Cart() {
		
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

	@Override
	public String toString() {
		return "Cart [id=" + id + ", name=" + name + ", details=" + details + ", fullPrice=" + fullPrice
				+ ", orderedDate=" + orderedDate + ", PickUpDate=" + pickUpDate + ", items=" + items + ", preOrder="
				+ preOrder + "]";
	}

	public String getPickUpDate() {
		return pickUpDate;
	}

	public void setPickUpDate(String pickUpDate) {
		this.pickUpDate = pickUpDate;
	}




	
	

}