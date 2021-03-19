package com.oraclejava.boot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NEWS")
public class News {
	
	@Id
	@Column (name = "NEWS_TITLE")
	private String newsTitle;
	
	@Column (name = "NEWS_LINK")
	private String newsLink;
	
	@Column (name = "NEWS_IMAGE_LINK")
	private String newsImageLink;
	
	
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsLink() {
		return newsLink;
	}
	public void setNewsLink(String newsLink) {
		this.newsLink = newsLink;
	}
	public String getImageLink() {
		return newsImageLink;
	}
	public void setImageLink(String imageLink) {
		this.newsImageLink = imageLink;
	}
	
	
	@Override
	public String toString() {
		return "News [newsTitle=" + newsTitle + ", newsLink=" + newsLink + ", newsImageLink=" + newsImageLink + "]";
	}
	
	
	
	
	
}


