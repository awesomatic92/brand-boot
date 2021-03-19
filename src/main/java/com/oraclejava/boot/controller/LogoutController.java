package com.oraclejava.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("login")
public class LogoutController {
	
	private static final Logger logger = LoggerFactory.getLogger(LogoutController.class);
	
	@GetMapping("/logout")
	public String logout(SessionStatus sessionStatus) {
		logger.info("로그아웃 중...");
		if(!sessionStatus.isComplete()) {
			sessionStatus.setComplete();
		}
		return "redirect:/";
	}
}
