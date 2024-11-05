package util;

import java.sql.Date;
import java.time.LocalDateTime;

import java.util.Calendar;
import java.util.Random;

public class OTPCode {
	public static String CreateOTP() {
		String result = "";
		Random rd = new Random();
		for (int i = 0; i < 5; i++) {
			result += rd.nextInt(10)+"";
		}
		return result;
	}
	public static Date timeOutOTP() {
		Date todaysDate = new Date(new java.util.Date().getTime());
		Calendar c = Calendar.getInstance();
		c.setTime(todaysDate);
		c.add(Calendar.DATE,1);
		Date timeOut = new Date(c.getTimeInMillis());
		return timeOut;
	}
	public static Date timeNow() {
		Date todaysDate = new Date(new java.util.Date().getTime());
		return todaysDate;
	}
	
	  public static void main(String[] args) { 
		
		  
		  
	  
	  }
	
}
