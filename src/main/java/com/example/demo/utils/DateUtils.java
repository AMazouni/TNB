package com.example.demo.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
 public static Date getDateByYear (Integer year) {
	 GregorianCalendar calendar = new GregorianCalendar(year,1,1);
	return calendar.getTime();
 }
 public static Integer getMonthsDiff(Date date) {
	 GregorianCalendar calendarDate = new GregorianCalendar();
	 calendarDate.setTime(date);
	 GregorianCalendar calendarNow = new GregorianCalendar();
	 if(calendarDate.get(Calendar.YEAR)==calendarNow.get(Calendar.YEAR)) {
		 return calendarNow.get(Calendar.MONTH)-calendarDate.get(Calendar.MONTH) ;
	 }
	 else {
		 return (calendarNow.get(Calendar.YEAR)-calendarDate.get(Calendar.YEAR))*12+calendarNow.get(Calendar.MONTH)-calendarDate.get(Calendar.MONTH) ;
	 }
	 
 }
 public  static Integer getYear(){
 	Date d=new Date();
	 Calendar c=new GregorianCalendar();
	 c.setTime(d);
	 return c.get(Calendar.YEAR);

 }
 public static Boolean compareDate(Date date1,Date date2) {
		long milliSeconde1 = date1.getTime();
		long milliSeconde2 = date2.getTime();
		if(milliSeconde1==milliSeconde2)
			return true;
		else {
			return false;
		}
 }
}
