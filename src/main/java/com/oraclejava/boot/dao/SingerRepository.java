package com.oraclejava.boot.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import com.oraclejava.boot.dto.Singer;

// CrudRepository<Entity name, ID Type>
public interface SingerRepository extends JpaRepository<Singer, Integer>, QuerydslPredicateExecutor<Singer>{
	
	// 원하는 가수들 삭제
	@Modifying
	@Query("DELETE FROM Singer s WHERE s.id IN (:sid)")
	public int delSingers(@Param("sid") Set<Integer> sid);
}
