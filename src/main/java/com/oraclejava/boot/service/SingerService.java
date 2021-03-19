package com.oraclejava.boot.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.oraclejava.boot.dto.Singer;
import com.querydsl.core.types.Predicate;

public interface SingerService {
	
	List<Singer> findAll();
	
	Singer findOne(int id);
	Singer save(Singer singer);
	
	Page<Singer> findAll(Pageable pageable);
	Page<Singer> findAll(Predicate predicate, Pageable pageable);
	
	
	// 삭제 기능 구현
	void delete(int id);
	void deleteAll(Set<Integer> singers);
	
}
