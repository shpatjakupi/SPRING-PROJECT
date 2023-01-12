package com.myapp.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	@Override
	public String toString() {
		return "Cart [id=" + id + ", name=" + name + ", details=" + details + ", fullPrice=" + fullPrice + "]";
	}

	public void setFullPrice(int fullPrice) {
		this.fullPrice = fullPrice;
	}
	
	
	

}
