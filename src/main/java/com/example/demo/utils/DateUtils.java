package com.example.demo.utils;

import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
 public static Date getDateByYear (Integer year) {
	 GregorianCalendar calendar = new GregorianCalendar(year,1,1);
	return calendar.getTime();
 }
 public static Integer getMonthsDiff(Date date) {
	 Date now = new Date();
	 Long msDiff = now.getTime() - date.getTime();
	 GregorianCalendar calendar = new GregorianCalendar();
	 calendar.setTimeInMillis(msDiff);
	 return calendar.get(calendar.MONTH);
 }
 
}
