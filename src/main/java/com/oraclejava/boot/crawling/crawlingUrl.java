package com.oraclejava.boot.crawling;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.oraclejava.boot.dto.News;

public class crawlingUrl {
		
    public static void main( String[] args ) throws IOException{  
    	
    	
    		   Document doc1 = Jsoup.connect("https://hypebeast.kr/fashion").get();  
	        
    		   Elements links = doc1.select("div.post-box-content-title a");
    		   
    		   ArrayList<String> newsInfoList = new ArrayList<String>();
    		   
    		   for (Element link : links) {  
    			   System.out.println("\nlink : " + link.attr("href"));  
    			   System.out.println("text : " + link.text());
	            
    			   String newslink = link.attr("href");
    			   String newstitle = link.text();
    			   
    			   newsInfoList.add(newslink);
    			   newsInfoList.add(newstitle);
    			   
    		   }  
	        
	        
    		   for (Element e : doc1.select("img")) {
    			   System.out.println(e.attr("data-srcset"));
	       
    			   String newsimglink = e.attr("data-srcset");
    			   
    			   newsInfoList.add(newsimglink);
    		   }
    		   
    		   
    		   for (String i : newsInfoList) {
    			   System.out.println("=========================="); 
    			   System.out.println(i);
    			   System.out.println("=========================="); 
    		   }
    		       		   
    		   
    		}
		}
