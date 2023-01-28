package com.myapp.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.spring.dao.CustomerDAO;
import com.myapp.spring.dto.CartDTO;
import com.myapp.spring.dto.ItemDTO;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public void saveOrder(CartDTO cartDTO, List<ItemDTO> items) {
		customerDAO.saveOrder(cartDTO, items);

	}

}
