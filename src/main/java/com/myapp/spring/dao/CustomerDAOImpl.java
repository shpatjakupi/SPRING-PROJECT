package com.myapp.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myapp.spring.dto.OrderDTO;
import com.myapp.spring.dto.ItemDTO;
import com.myapp.spring.entity.Order;
import com.myapp.spring.entity.Item;

@Repository
public class CustomerDAOImpl implements CustomerDAO {


	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveOrder(OrderDTO orderDTO, List<ItemDTO> items) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Order order = new Order();
		order.setOrderedDate(orderDTO.getOrderedDate());
		order.setPickUpDate(orderDTO.getPickUpDate());
		order.setDetails(orderDTO.getDetails());
		order.setFullPrice(orderDTO.getFullPrice());
		order.setName(orderDTO.getName());
		order.setPreOrder(orderDTO.isPreOrder());
		order.setOrderDone(orderDTO.isOrderDone());;
		currentSession.saveOrUpdate(order);
        
        for(ItemDTO itemdto : items) {
        	Item item = new Item();
        	item.setDetails(itemdto.getDetails());
        	item.setOrder(order);
        	currentSession.saveOrUpdate(item);
        }

	}
	


}
