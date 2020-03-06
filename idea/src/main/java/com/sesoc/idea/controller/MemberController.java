package com.sesoc.idea.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sesoc.idea.dao.MemberDAO;
import com.sesoc.idea.vo.MemberVO;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberDAO dao;
	
	@RequestMapping(value="signupForm", method=RequestMethod.GET)
	public String signupForm() {
		logger.info("회원가입 폼 이동");
		return "signupForm";
	}
	
	@RequestMapping(value="signup", method=RequestMethod.POST)
	public String signup(MemberVO vo) {
		logger.info("회원가입 하기");
		int result = dao.signup(vo);
		if(result == 1) {
			logger.info("회원가입 성공");
			return "redirect:loginForm";
		}
		logger.info("회원가입 실패");
		return "redirect:signupForm";
	}
	
	@RequestMapping(value="loginForm", method=RequestMethod.GET)
	public String loginForm() {
		logger.info("로그인 폼 이동");
		return "loginForm";		
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(MemberVO vo, HttpSession session) {
		logger.info("로그인 하기");
		int result = dao.login(vo);
		if(result != 1) {
			logger.info("로그인 실패");
			return "redirect:loginForm";
		}
		logger.info("로그인 성공");
		session.setAttribute("userid", vo.getUserid());
		return "redirect:/";
		
	}

	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.info("로그아웃 하기");
		session.removeAttribute("userid");
		return "redirect:/";		
	}	
	
	@RequestMapping(value="memberUpdateForm", method=RequestMethod.GET)
	public String memberUpdateForm() {
		logger.info("회원 정보 수정 폼 이동");
		return "memberUpdateForm";		
	}
	
	@RequestMapping(value="memberUpdate", method=RequestMethod.POST)
	public String memberUpdate(MemberVO vo, HttpSession session) {
		String userid = (String)session.getAttribute("userid");
		vo.setUserid(userid);
		
		int cnt = dao.memberUpdate(vo);
		
		if(cnt == 0) {
			logger.info("회원정보 수정 실패");
			return "redirect:/";
		}	
		logger.info("회원 정보 수정 성공");
		return "redirect:/";		
	}
	
	@RequestMapping(value="ideaSearch", method=RequestMethod.GET)
	public String ideaSearch() {
		logger.info("아이디어 검색");
		return "ideaSearch";
	}
	
}
