package com.jucaipen.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestModth {
	
	public static void main(String[] args) {
		String createDate = "2008-12-01 12:22:10";
		   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   try {
		    Date date = sdf.parse(createDate);
		    Calendar cl = Calendar.getInstance();
		    cl.setTime(date);
		    cl.add(Calendar.DATE,1);
		    String temp = "";
		    temp = sdf.format(cl.getTime());
		    System.out.println(temp);
		   } catch (ParseException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
	}

}
