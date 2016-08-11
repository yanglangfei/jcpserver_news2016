package com.jucaipen.test;

import java.util.Date;
import com.jucaipen.utils.TimeUtils;

public class StringTest {
	public static void main(String[] args) {
		String time = TimeUtils.format(new Date(), "yyyyMMddHHmmssSSSS");
		System.out.println("time:" + time);
	}
	
	public boolean call(Integer t){
		System.out.println("call:"+t);
		return true;
	}
	
	
}
