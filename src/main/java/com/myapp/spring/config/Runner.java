package com.myapp.spring.config;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Stack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myapp.spring.entity.Cart;
import com.myapp.spring.entity.Order;

public class Runner {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(DemoAppConfig.class);
        SessionFactory sessionFactory = context.getBean(SessionFactory.class);
        Session currentSession = sessionFactory.openSession();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = formatter.format(new Date());
   
        Query<Cart> theQuery = currentSession.createQuery("from Cart where date = :currentDate",Cart.class);
		theQuery.setParameter("currentDate", currentDate);

		List<Cart> carts = theQuery.getResultList();
       
		for(Cart cart : carts) {
			List<Order> list = cart.getOrders();
			for(Order order : list) {
				System.out.println(order.getDetails());
			}
		}
		// And Get Orders from that query
		
		
        
	}
}
