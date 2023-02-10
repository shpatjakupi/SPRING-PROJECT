package com.myapp.spring.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class DateUtil {
	public enum DateKey {
		TODAY,
	    YESTERDAY,
	    THIS_WEEK,
	    LAST_WEEK_START,
	    LAST_WEEK_END,
	    MONTH_START,
	    LAST_MONTH_START,
	    LAST_MONTH_END
	}
	
    private static HashMap<DateKey,Calendar> getDate = new HashMap<>();
    
    static {
    	Calendar today = Calendar.getInstance();
        getDate.put(DateKey.TODAY, today);
        
        
        Calendar yesterDay = Calendar.getInstance();
        yesterDay.add(Calendar.DATE, -1);
        getDate.put(DateKey.YESTERDAY, yesterDay);
    
        Calendar thisWeek = Calendar.getInstance();
        thisWeek.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        getDate.put(DateKey.THIS_WEEK, thisWeek);
    
        Calendar lastWeek = Calendar.getInstance();
        lastWeek.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        lastWeek.add(Calendar.DATE, -7);
        getDate.put(DateKey.LAST_WEEK_START, lastWeek);

        Calendar lastWeekEnd = Calendar.getInstance();
        lastWeekEnd.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        lastWeekEnd.add(Calendar.DATE, -7);
        lastWeekEnd.add(Calendar.DATE, 6);
        getDate.put(DateKey.LAST_WEEK_END, lastWeekEnd); 
        
        Calendar monthStart = Calendar.getInstance();
        monthStart.set(Calendar.DAY_OF_MONTH,1);
        getDate.put(DateKey.MONTH_START, monthStart);
        
        Calendar lastMonth = Calendar.getInstance();
        lastMonth.set(Calendar.MONTH, lastMonth.get(Calendar.MONTH) - 1);
        lastMonth.set(Calendar.DAY_OF_MONTH, 1);
        getDate.put(DateKey.LAST_MONTH_START, lastMonth);

        Calendar lastMonthEnd = Calendar.getInstance();
        lastMonthEnd.set(Calendar.DAY_OF_MONTH, 1);
        lastMonthEnd.add(Calendar.DATE, -1);
        getDate.put(DateKey.LAST_MONTH_END, lastMonthEnd);
        
    }
    private Date formatDate(DateKey dateKey) {
		
	    Calendar date = getDate.get(dateKey);
	    Date dateTime = date.getTime();
	    return dateTime;
	}
    
    public ArrayList<Date> getArrayOfDates(String dateKey) {
	 
	    ArrayList<Date> list = new ArrayList<>();
	    switch (dateKey) {
	        case "TODAY":
	            list.add(formatDate(DateUtil.DateKey.TODAY));
	            break;
	        case "YESTERDAY":
	            list.add(formatDate(DateUtil.DateKey.YESTERDAY));
	            break;
	        case "THIS_WEEK":
	            list.add(formatDate(DateUtil.DateKey.THIS_WEEK));
	            list.add(formatDate(DateUtil.DateKey.TODAY));
	            break;
	        case "LAST_WEEK":
	            list.add(formatDate(DateUtil.DateKey.LAST_WEEK_START));
	            list.add(formatDate(DateUtil.DateKey.LAST_WEEK_END));
	            break;
	        case "THIS_MONTH":
	            list.add(formatDate(DateUtil.DateKey.MONTH_START));
	            list.add(formatDate(DateUtil.DateKey.TODAY));
	            break;
	        case "LAST_MONTH":
	            list.add(formatDate(DateUtil.DateKey.LAST_MONTH_START));
	            list.add(formatDate(DateUtil.DateKey.LAST_MONTH_END));
	            break;
	        default:
	            break;
	    }
	    return list;
	}

}
