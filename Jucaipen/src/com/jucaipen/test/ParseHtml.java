package com.jucaipen.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParseHtml {
	
	public static void main(String[] args) {
		String html="≤‚ ‘<img src='http://img.jucaipen.com/jucaipenUpload/2015/7/15/201571517439.gif'>≤‚ ‘";
		Document tag = Jsoup.parse(html);
		Elements eles = tag.getElementsByTag("img");
		System.out.println(tag.body().text());
		for(Element e : eles){
			System.out.println(e.toString());
			
		}
	}
	

}
