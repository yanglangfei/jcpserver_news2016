package com.jucaipen.test;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
public class ParseHtml {
	
	public static void main(String[] args) {
	    Connection conn = Jsoup.connect("https://s.taobao.com/search?q=õùõ÷&commend=all&ssid=s5-e&search_type=item&sourceId=tb.index&spm=a21bo.50862.201856-taobao-item.1&ie=utf8&initiative_id=tbindexz_20160817");
	     try {
			Document doc = conn.get();
			System.out.println("doc:"+doc.body().toString());
		/*	Elements tagA = doc.getElementsByTag("a");
			for(Element e : tagA){
				//String src=e.attr("src");
				System.out.println("src:"+e.text());
			}*/
			System.out.println("popop");
			System.out.println("lll");
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	

}
