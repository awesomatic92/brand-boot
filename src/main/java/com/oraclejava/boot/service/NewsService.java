package com.oraclejava.boot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.oraclejava.boot.dto.News;
import com.querydsl.core.types.Predicate;

public interface NewsService {

	List<News> findAll();
	
	Page<News> findAll(Pageable pageable);
	Page<News> findAll(Predicate predicate, Pageable pageable);
	
	
	
	
}
