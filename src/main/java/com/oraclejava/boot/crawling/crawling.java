package com.oraclejava.boot.crawling;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class crawling {
	
	public static void main(String[] args) {
		Document doc = null;
		
		String url = "https://hypebeast.kr/fashion";
		 
		
		try { 
			doc=Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();	
		}
					
		Elements element1 = doc.select("div.posts");
		
		
//		Elements links = doc.select("div.post-box");
		
		System.out.println("============================================================");
		
		Iterator<Element> ie1 = element1.select("a.title").iterator();
		
		
		while (ie1.hasNext()) {
			
			System.out.println(ie1.next().text());
		
		
		System.out.println("============================================================");
							
		}
		
//		Elements links = doc.select("hb-tab-content tab-content tab-pane posts post-box");
//		for (Element link : links) {
//		    String href = link.attr("href");
//
//		    String absUrl = link.absUrl("href");
//
//		    System.out.println(href);
//		    System.out.println(absUrl);
//		    
//		}
		
		
		
		
		
	}
}
