package com.myapp.spring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.myapp.spring.dto.CartDTO;

@Entity
@Table(name="Item")
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "Cart_id")
	@JsonBackReference
    private Cart cart;
	
	@Column(name="Details")
	private String details;
	
	public Item() {
		
	}
	public Cart getCart() {
        return cart;
    }
	
	
    public void setCart(Cart cart) {
        this.cart = cart;
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