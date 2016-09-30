package com.jucaipen.test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class FileTest {
	
	public static void main(String[] args) {
		File f = createFile();
		writeMsg(f,"msg");
		readMsg(f);
	}

	private static String readMsg(File f) {
		try {
			FileReader fr=new FileReader(f);
			BufferedReader reader=new BufferedReader(fr);
			int line=1;
			String str=null;
			while ((str=reader.readLine())!=null) {
			    str+=reader.readLine();
				line++;
			}
			reader.close();
			return str;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static void writeMsg(File f,String msg)  {
		//Ð´ÈëÊý¾Ý
		try {
			FileWriter fw=new FileWriter(f, true);
			fw.write(msg+"\r\n");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static File createFile() {
		File f=new File("d:/test/my/user.txt");
		if(!f.exists()){
			try {
				f.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return f;
	}

}
