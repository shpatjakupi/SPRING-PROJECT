package com.myapp.spring.dto;

import java.util.List;



public class ParseOrderDTO {
	
  
    private OrderDTO order;

    
    private List<ItemDTO> items;
	
	public ParseOrderDTO() {
	
	}	
	public OrderDTO getOrder() {
	
		return order;
	}
	public void setOrder(OrderDTO order) {
		this.order = order;
	}
	public List<ItemDTO> getItems() {
		return items;
	}
	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "fullRepo [cart=" + order + ", orders=" + items + "]";
	}


}
