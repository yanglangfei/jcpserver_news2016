package com.jucaipen.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
public class FileTest {
	
	public static void main(String[] args) {
		File f=new File("d:/test/my/user.txt");
		if(!f.exists()){
			try {
				f.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		try {
			//Ð´ÈëÊý¾Ý
			FileWriter fw=new FileWriter(f, true);
			fw.write("1 "+"\r\n");
			fw.flush();
			fw.close();
			FileReader fr=new FileReader(f);
			BufferedReader reader=new BufferedReader(fr);
			int line=1;
			String str=null;
			while ((str=reader.readLine())!=null) {
				System.out.println(line+"   "+str);
				line++;
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
