package com.jucaipen.test;
public class CmdTest {
	public static void main(String[] args) {
		long last = System.currentTimeMillis();
		System.out.println("ºÄÊ±:"+(System.currentTimeMillis()-last));
	}
	public static int ran(int min,int max){
	    // Random random=new Random();
		// return random.nextInt(max)%(max-min+1) + min;
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
