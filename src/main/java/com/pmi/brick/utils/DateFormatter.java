package com.pmi.brick.utils;

import java.util.Calendar;
import java.util.Date;

public class DateFormatter {
	final static long day=86400000;        //24 hours in milliseconds
	 public static String formatDate(Date date) {
		Date now=new Date();
		Calendar calNow = Calendar.getInstance();
		Calendar calDate = Calendar.getInstance();
		calNow.setTime(now);
		calDate.setTime(date);
		boolean today = calNow.get(Calendar.YEAR) == calDate.get(Calendar.YEAR) &&
		                  calNow.get(Calendar.DAY_OF_YEAR) == calDate.get(Calendar.DAY_OF_YEAR);
		
		if(today)
			return "сьогодн≥";
		boolean yesterday = now.getTime()-date.getTime()<day*2 &&
                calNow.get(Calendar.DAY_OF_YEAR-1) == calDate.get(Calendar.DAY_OF_YEAR);
		if(yesterday)
			return "вчора";
		
		boolean sameMonth= now.getTime()-date.getTime()<day*31;
		if(sameMonth)		{
			int daysDifference=(int) ((now.getTime()-date.getTime())/day);
			if(daysDifference<5)
		    return Integer.toString(daysDifference)+" дн≥ тому";
			if(daysDifference>=5&&daysDifference<7)
				 return Integer.toString(daysDifference)+" дн≥в тому";
			if(daysDifference>=7&&daysDifference<=13)
				return "тиждень тому";
			if(daysDifference>=14&&daysDifference<=20)
				return "два тижн≥ тому";
			if(daysDifference>=21)
				return "три тижн≥ тому";
		}
		
		boolean laterThanMonth= now.getTime()-date.getTime()>day*31 &&
				             now.getTime()-date.getTime()<day*365;
		if(laterThanMonth)		{
			int monthsDifference=(int) ((now.getTime()-date.getTime())/day*30);
			return Integer.toString(monthsDifference)+" м≥с€ц≥ тому";
			
		}
		return "б≥льше року тому";
	    }
}
