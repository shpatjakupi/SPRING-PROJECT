package com.myapp.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.dto.ParseOrderDTO;
import com.myapp.spring.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {
	@Autowired
	private CustomerService CustomerService;
	
	
	@PostMapping("/sendOrder") 
	public ResponseEntity<String> addOrder(@RequestBody ParseOrderDTO req) {
		CustomerService.saveOrder(req.getOrder(), req.getItems());
	 
		return new ResponseEntity<>("The shop has got the order!", HttpStatus.OK);

	}
}
