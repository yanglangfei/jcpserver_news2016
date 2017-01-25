package com.jucaipen.test;
import java.util.Random;
public class CmdTest {
	
	public static void main(String[] args) {
		
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
