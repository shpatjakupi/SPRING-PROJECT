package com.myapp.spring.config;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Stack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myapp.spring.entity.Cart;

public class Runner {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(DemoAppConfig.class);
        SessionFactory sessionFactory = context.getBean(SessionFactory.class);
        Session currentSession = sessionFactory.openSession();

     // Get current date and time
        Instant now = Instant.now();

        // Format as ISO 8601 string
        DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
        String currentDate = formatter.format(now);
       
        Query<Cart> theQuery = currentSession.createQuery("from Cart c where c.date = :currentDate", Cart.class);
        theQuery.setParameter("currentDate", currentDate);
		
		// execute query and get result list
		List<Cart> carts = theQuery.getResultList();
        
		for(Cart cart : carts) {
			System.out.println(cart.toString());
		}
		// And Get Orders from that query
		
		
        
	}
}
