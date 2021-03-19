package com.oraclejava.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.oraclejava.boot.annotation.NoAuth;
import com.oraclejava.boot.dto.Employee;
import com.oraclejava.boot.dto.Login;
import com.oraclejava.boot.service.EmpService;

@Controller
@RequestMapping(value = "/login")
@SessionAttributes("login")
public class LoginController {
	
	@Autowired
	private EmpService empService;
	
	@GetMapping
	@NoAuth
	public String loginForm() {
		return "login";
	}
	
	// 초기 객체 취득
	@ModelAttribute("login")
	public Login createInitLogin() {
		Login login = new Login();
		return login;
	}
	
	// 로그인 처리
	@PostMapping
	@NoAuth
	public String loginProcess(@ModelAttribute("login") Login login) {
		Employee emp = empService.login(login.getId(), login.getPassword());
		if (emp != null) {
			// 로그인 성공
			login.setLoginType(emp.getLoginType());
			return "redirect:/";
		} else {
			// 로그인 실패
			return "login";
		}
	}
}
