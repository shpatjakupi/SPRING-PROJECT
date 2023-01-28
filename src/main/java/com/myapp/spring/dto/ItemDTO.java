package com.myapp.spring.dto;

import java.util.ArrayList;
import java.util.List;

import com.myapp.spring.entity.Cart;
import com.myapp.spring.entity.Item;

public class ItemDTO {

    private String details;
    private CartDTO cartDTO;
    
    public ItemDTO() {
    }

    
	


	public void setCartDTO(CartDTO cartDTO) {
		this.cartDTO = cartDTO;
	}

	public ItemDTO(Item item) {
        this.details = item.getDetails();
     
    }
    
    public static List<ItemDTO> getItemDTOList(List<Item> items) {
    	List<ItemDTO> itemsDTO = new ArrayList<>();
    	for(Item item : items) {
    		itemsDTO.add(new ItemDTO(item));
    	}
    	return itemsDTO;
    }
 

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
