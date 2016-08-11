package com.jucaipen.test;

import java.lang.reflect.Method;
public class ParseHtml {
	
	public static void main(String[] args) {
	
		try {
			Class<?> test = Class.forName("com.jucaipen.test.StringTest");
			Method ms = test.getMethod("call", Integer.class);
			ms.invoke(test.newInstance(), 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
