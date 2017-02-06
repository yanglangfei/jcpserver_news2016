package com.jucaipen.test;
import java.util.Random;
public class CmdTest {
	
	public static void main(String[] args) {
		long last = System.currentTimeMillis();
		for(int i=0;i<1000000;i++){
			int ran = ran(0, 100);
			System.out.println(i+"  ran:"+ran);
		}
		System.out.println("ºÄÊ±:"+(System.currentTimeMillis()-last));
	}
	public static int ran(int min,int max){
		Random random=new Random();
		//return random.nextInt(max)%(max-min+1) + min;
		return (int)((max-min)*Math.random()+min);
	}
	
	
	public static boolean One(){
		System.out.println("One");
		return false;
	}
	
	public static boolean Two(){
		System.out.println("Two");
		return true;
	}
	
}
