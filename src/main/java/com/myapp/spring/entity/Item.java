package com.myapp.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Item")
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "Order_id")
    private Order order;
	
	@Column(name="Details")
	private String details;
	
	public Item() {
		
	}
	public Order getOrder() {
        return order;
    }
	
	
    public void setOrder(Order order) {
        this.order = order;
    }
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	

}