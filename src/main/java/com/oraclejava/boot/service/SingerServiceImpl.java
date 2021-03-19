package com.oraclejava.boot.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.oraclejava.boot.dao.SingerRepository;
import com.oraclejava.boot.dto.Singer;
import com.querydsl.core.types.Predicate;

@Service
@Transactional(readOnly = true)
public class SingerServiceImpl implements SingerService {

	@Autowired
	private SingerRepository singerRepository;
	
	@Override
	public List<Singer> findAll() {
		
		return Lists.newArrayList(singerRepository.findAll());
	}

	@Override
	public Singer findOne(int id) {
		
		return singerRepository.findById(id).get();
	}
	
	@Transactional
	@Override
	public Singer save(Singer singer) {
		
		return singerRepository.save(singer);
	}

	@Override
	public Page<Singer> findAll(Pageable pageable) {
		int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
		pageable = PageRequest.of(page, pageable.getPageSize(), Sort.by("id").descending());
		return singerRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public void delete(int id) {
		singerRepository.deleteById(id);
		
	}

	@Override
	@Transactional
	public void deleteAll(Set<Integer> singers) {
		singerRepository.delSingers(singers);
	}
	
	@Override
	public Page<Singer> findAll(Predicate predicate, Pageable pageable) {
		int page = (pageable.getPageNumber() == 0) ? 0 : 
			(pageable.getPageNumber() - 1);
		//늙은가수 우선
		pageable = PageRequest.of(page, pageable.getPageSize(), 
				Sort.by("birthDate").ascending());
		return singerRepository.findAll(predicate, pageable);
	}
}
