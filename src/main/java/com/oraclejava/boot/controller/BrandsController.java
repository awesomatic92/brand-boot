package com.oraclejava.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.oraclejava.boot.annotation.NoAuth;

@Controller
public class BrandsController {
	
	private static final Logger logger = LoggerFactory.getLogger(BrandsController.class);
	
	@GetMapping("/supreme")
	@NoAuth
	public String supreme() {
		logger.info("슈프림 페이지입니다.");
		return "brands/supreme";				// resources -> templates -> index.html
	}
	
	
}
