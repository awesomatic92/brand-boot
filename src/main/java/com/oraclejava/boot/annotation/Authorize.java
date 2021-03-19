package com.oraclejava.boot.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
public @interface Authorize {

	/*
	 * 권한을 정의한다.
	 * @return 권한(A: 최고 관리자, B: 정직원, C: 수습직원)
	 */
	String[] roles() default {};
	
}
