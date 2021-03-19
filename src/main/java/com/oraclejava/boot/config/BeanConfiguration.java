package com.oraclejava.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.oraclejava.boot.interceptor.LoggingInterceptor;
import com.oraclejava.boot.interceptor.LoginInterceptor;

@Configuration
public class BeanConfiguration {
	
	@Bean
	public LoggingInterceptor loggingInterceptor() throws Exception {
		return new LoggingInterceptor();
	}
	
	@Bean
	public LoginInterceptor loginInterceptor() throws Exception {
		return new LoginInterceptor();
	}
	
}
