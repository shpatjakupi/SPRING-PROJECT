package com.myapp.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myapp.spring.dto.CartDTO;
import com.myapp.spring.dto.ItemDTO;
import com.myapp.spring.entity.Cart;
import com.myapp.spring.entity.Item;

@Repository
public class CustomerDAOImpl implements CustomerDAO {


	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveOrder(CartDTO cartDTO, List<ItemDTO> items) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Cart cart = new Cart();
		cart.setOrderedDate(cartDTO.getOrderedDate());
		cart.setPickUpDate(cartDTO.getPickUpDate());
		cart.setDetails(cartDTO.getDetails());
		cart.setFullPrice(cartDTO.getFullPrice());
		cart.setName(cartDTO.getName());
		cart.setPreOrder(cartDTO.isPreOrder());
		currentSession.saveOrUpdate(cart);
        
        for(ItemDTO itemdto : items) {
        	Item item = new Item();
        	item.setDetails(itemdto.getDetails());
        	item.setCart(cart);
        	currentSession.saveOrUpdate(item);
        }

	}

}
