package com.sesoc.idea.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//세션에 저장된 아이디 가져오기
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("userid");
		
		//로그인되지 않았다면 로그인 페이지로 이동시키기
		if(userid == null) {
			response.sendRedirect(request.getContextPath() +"/loginForm");
			return false;			
		}
		
		//로그인되었다면 그대로 진행
		return true;	
	}
}
