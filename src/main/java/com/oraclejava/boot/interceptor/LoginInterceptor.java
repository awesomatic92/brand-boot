package com.oraclejava.boot.interceptor;

import java.lang.reflect.Method;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.oraclejava.boot.annotation.Authorize;
import com.oraclejava.boot.annotation.NoAuth;
import com.oraclejava.boot.dto.Login;

public class LoginInterceptor implements HandlerInterceptor{
	
	private final static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(handler instanceof HandlerMethod) {
			
			//@NoAuth가 붙어있는지 체크해서 붙어있으면 무사 통과
			HandlerMethod hm = (HandlerMethod)handler;
			Method method = hm.getMethod();
			NoAuth noAuth = AnnotationUtils.findAnnotation(method, NoAuth.class);
			if(noAuth != null) {
				return true;
			}
			
			// /spring-boot란 컨텍스트 패스 취득
			String contextPath = request.getContextPath();
			
			// 사용자 인증
			HttpSession session = request.getSession();
			try {
				Login login = (Login)session.getAttribute("login");
				if(login.getLoginType() == null || login.getLoginType().equals("")) {
					response.sendRedirect("/login");
					return false;
				} else if (request.getRequestURI().equals("singer/new")) {
					if (login.getLoginType().equals("A")) {
						//수습사원이 노래 추가할 경우(금지)
						response.sendRedirect(contextPath + "/login");
						return false;
					}
				}
				//로그인은 했다!
				//@Authorize 권한 취득
				Authorize authorize = AnnotationUtils.findAnnotation(method, Authorize.class);
				
				if (authorize != null) {
					int index = Arrays.binarySearch(authorize.roles(), "C");
					if (index >= 0) {
						if(!login.getLoginType().equals("C")) {
							response.sendRedirect("/NoAuth");
							return false;
						}
					}
				}
				
			}catch(Exception e) {
				response.sendRedirect("/login");
				return false;
			}
		}
			return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
	
}
