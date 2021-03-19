package com.oraclejava.boot;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BrandBootApplication extends SpringBootServletInitializer {
	
	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(BrandBootApplication.class);
	}

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext ctx =

		SpringApplication.run(BrandBootApplication.class, args);
		
		System.out.println("Brand 부트 실행 중....");
		
		System.in.read();
		ctx.close();
	}
}
