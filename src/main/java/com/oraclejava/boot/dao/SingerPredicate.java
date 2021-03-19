package com.oraclejava.boot.dao;

import com.oraclejava.boot.dto.QSinger;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public class SingerPredicate {

	public static Predicate search(String name) {
		QSinger singer = QSinger.singer;
		
		BooleanBuilder builder = new BooleanBuilder();
		if (name != null) {
			builder
				.and(singer.firstName.toLowerCase().like("%" + name.toLowerCase() + "%"))
			    .or(singer.lastName.toLowerCase().like("%" + name.toLowerCase() + "%"));
			
		}
		return builder;
	}
}
