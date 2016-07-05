package com.jucaipen.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.jucaipen.model.User;

public class TestModth {
	
	public static void main(String[] args) {
		Method[] ms = User.class.getMethods();
		Field[] fs = User.class.getDeclaredFields();
		for(int i=0;i<fs.length;i++){
			System.out.println(ms[i].getName());
		}
	}

}
