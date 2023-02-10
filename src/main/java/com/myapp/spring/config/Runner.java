package com.myapp.spring.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myapp.spring.entity.Order;
import com.myapp.spring.utils.DateUtil;
import com.myapp.spring.entity.Item;

public class Runner {
	public static void main(String[] args) throws ParseException {

		ApplicationContext context = new AnnotationConfigApplicationContext(DemoAppConfig.class);
        SessionFactory sessionFactory = context.getBean(SessionFactory.class);
        Session currentSession = sessionFactory.openSession();

        DateUtil util = new DateUtil();
        
        ArrayList<Date> theList = util.getArrayOfDates("LAST_WEEK");
        Query<Order> theQuery = null;
        
    
    	if(theList.size() == 1) {
    		 Date firstDate = theList.get(0);

    		 theQuery = currentSession.createQuery("from Order where DATE(pickUpDate) = :currentDate",Order.class);
    	     theQuery.setParameter("currentDate", firstDate);	
    		
    	}
    	else {
    		 Date firstDate = theList.get(0);
    		 Date lastDate = theList.get(1);
    		 theQuery = currentSession.createQuery("from Order where DATE(pickUpDate) BETWEEN :firstDate and :lastDate",Order.class);
    	     theQuery.setParameter("firstDate", firstDate);	
    	     theQuery.setParameter("lastDate", lastDate);	
    	}  
        	
    
		
		List<Order> orders = theQuery.getResultList();
		System.out.println(orders.toString());
	
		
       
	}
	

	





	
	

	
	
}

