package com.myapp.spring.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.dto.OrderDTO;
import com.myapp.spring.dto.ShowOrderDTO;
import com.myapp.spring.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminRestController {
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/getTodaysOrders") // fetch every minute in ReactJS
	public ResponseEntity<List<ShowOrderDTO>> showTodaysOrder() {
		List<ShowOrderDTO> todaysOrderList = new ArrayList<ShowOrderDTO>();
	     
		List<OrderDTO> todaysOrder = adminService.getOrdersFromToday();
		
		for(OrderDTO order : todaysOrder) {
			ShowOrderDTO orderDTO = new ShowOrderDTO();
			orderDTO.setOrder(order);
			todaysOrderList.add(orderDTO);
			}
	
		return new ResponseEntity<>(todaysOrderList, HttpStatus.OK);
	} 
	
	@PutMapping("/updateOrderToDone/{orderId}")
	public ResponseEntity<String> setOrderToDone(@PathVariable int orderId) {
		
		adminService.setOrderToDone(orderId);
		
		return new ResponseEntity<>("The order is set to Done!", HttpStatus.OK);
		
	}
	
	@GetMapping("/getOrdersByDate/{dateKey}")
	public ResponseEntity<List<ShowOrderDTO>> setOrderToDone(@PathVariable String dateKey) {
		
		List<ShowOrderDTO> todaysOrderList = new ArrayList<ShowOrderDTO>();
	     
		List<OrderDTO> orders = adminService.getOrderByDate(dateKey);
		
		for(OrderDTO order : orders) {
			ShowOrderDTO orderDTO = new ShowOrderDTO();
			orderDTO.setOrder(order);
			todaysOrderList.add(orderDTO);
			}
	
		return new ResponseEntity<>(todaysOrderList, HttpStatus.OK);
		
	}

}
