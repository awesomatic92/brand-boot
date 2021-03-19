package com.oraclejava.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.oraclejava.boot.interceptor.LoggingInterceptor;
import com.oraclejava.boot.interceptor.LoginInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	@Autowired
	private LoggingInterceptor loggingInterceptor;
	
	@Autowired
	private LoginInterceptor loginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// registry.addInterceptor(loggingInterceptor);
		registry.addInterceptor(loginInterceptor);
	}
	
}
