package com.oraclejava.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.oraclejava.boot.dao.NewsRepository;
import com.oraclejava.boot.dto.News;
import com.querydsl.core.types.Predicate;

@Service
@Transactional(readOnly = true)
public class NewsServiceImpl implements NewsService {
	
	@Autowired
	private NewsRepository newsrepository;
	
	
	
	
	@Override
	public List<News> findAll() {
		
		return Lists.newArrayList(newsrepository.findAll());
	}

	@Override
	public Page<News> findAll(Pageable pageable) {

		return newsrepository.findAll(pageable);
	}

	@Override
	public Page<News> findAll(Predicate predicate, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
