package com.jucaipen.test;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParseHtml {
	
	public static void main(String[] args) {
	    Connection conn = Jsoup.connect("http://www.baidu.com/baidu?tn=monline_3_dg&ie=utf-8&wd=wangbaoqiang");
	     try {
			Document doc = conn.get();
			Elements tagA = doc.getElementsByTag("a");
			for(Element e : tagA){
				//String src=e.attr("src");
				System.out.println("src:"+e.text());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	

}
