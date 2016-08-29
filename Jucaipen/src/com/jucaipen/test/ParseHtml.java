package com.jucaipen.test;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParseHtml {

/*	public static void main(String[] args) {
		Document doc = null;
		try {
			doc = Jsoup.connect(
					"http://www.tvsou.com/programjw/TV_5/Channel_26/W5.htm")
					.get();
			System.out.println("doc:" + doc.html());
			Elements content = doc.getElementsByClass("tvgenre");
			for (int i = 0; i < content.size(); i++) {
				Elements times = content.get(i).getElementsByTag("span");
				Elements pm1 = content.get(i).getElementsByTag("a");
				for (int j = 0; j < times.size(); j++) {
					String src = pm1.get(j).attr("href");
					System.out.println("time:" + times.get(j).html()
							+ "  programys:" + pm1.get(j).html() + "  链接:"
							+ src);
				}
			}
		} catch (Exception e) {
		}
	}*/
	
	public static void main(String[] args) {
		try {
			Document doc=Jsoup.connect("http://image.so.com/i?src=360pic_strong&q=风景").get();
		    Elements scripts = doc.getElementsByTag("script");
		    ScriptEngineManager manager=new ScriptEngineManager();
		    ScriptEngine engine = manager.getEngineByName("JavaScript");
			for(int i=0;i<scripts.size();i++){
				Element script = scripts.get(i);
				if(script.toString().contains("window.initData")){
					System.out.println("sc:"+script.toString());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
