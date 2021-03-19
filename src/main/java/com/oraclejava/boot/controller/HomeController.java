package com.oraclejava.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.oraclejava.boot.annotation.NoAuth;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/")
	@NoAuth
	public String home() {
		logger.info("홈");
		return "redirect:/index" ;				// resources -> templates -> index.html
	}
	
	@GetMapping("/join")
	@NoAuth
	public String join() {
		logger.info("회원가입 페이지");
		return "join" ;				// resources -> templates -> index.html
	}
	
	@GetMapping("/NoAuth")
	@NoAuth
	public String noauth() {
		logger.info("No Auth 페이지입니다...");
		return "noAuth";
	}
	
}
