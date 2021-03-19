package com.oraclejava.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oraclejava.boot.dto.News;

public interface NewsRepository extends JpaRepository<News, String>
	{
	
	
}
