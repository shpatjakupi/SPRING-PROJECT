package com.myapp.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.spring.dao.AdminDAO;
import com.myapp.spring.dto.CartDTO;
import com.myapp.spring.entity.Cart;


@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDAO;
	
	@Override
	@Transactional
	public List<CartDTO> getOrdersFromToday() {
		return adminDAO.getOrdersFromToday();
	}

}
