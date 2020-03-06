package com.sesoc.idea.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.sesoc.idea.dao.IdeaDAO;
import com.sesoc.idea.vo.IdeaVO;

import com.sesoc.idea.util.PageNavigator;


@Controller
public class IdeaController {
	
	private static final Logger logger = LoggerFactory.getLogger(IdeaController.class);
	
	private final int countPerPage = 5;
	private final int pagePerGroup = 5;

	@Autowired
	private IdeaDAO dao;
	
	@RequestMapping(value="ideaHint", method=RequestMethod.GET)
	public String ideaHint() {
		logger.info("아이디어 힌트 얻기");
		return "ideaHint";
	}
	
	@RequestMapping(value="ideaWriteForm", method=RequestMethod.GET)
	public String ideaWriteForm() {
		logger.info("아이디어 등록 폼 이동");
		return "ideaWriteForm";
	}
	
	@RequestMapping(value="ideaWrite", method=RequestMethod.POST)
	public String ideadWrite(IdeaVO vo, HttpSession session) {
		logger.info("아이디어 등록");
		
		String userid = (String)session.getAttribute("userid");
		vo.setUserid(userid);
		
		int cnt = dao.ideaWrite(vo);
		if(cnt != 1) {
			logger.info("아이디어 등록 실패");	
		}
		logger.info("아이디어 등록 성공");	
		return "redirect:/";
	}
	
	@RequestMapping(value="ideaList", method=RequestMethod.GET)
	public String ideaList(HttpSession session, Model model, IdeaVO vo) {
		logger.info("아이디어 모음 이동");
		
		//세션에서 로그인한 아이디 가져오기
		String userid = (String)session.getAttribute("userid");
		
		//DB에서 아이디어 쓴 것 가져오기
		ArrayList<IdeaVO> list = dao.ideaList(userid);
		
		if(list.isEmpty()) {
			logger.info("아이디어 없음");
			return "redirect:noList";
		}
		logger.info("아이디어 있음");
		
		model.addAttribute("list", list);
	
		return "ideaList";
	}
	
	

	@RequestMapping(value="ideaList2", method=RequestMethod.GET)
	public String ideaListPaging(HttpSession session, Model model
		 ,@RequestParam(value="currentPage", defaultValue="1") int currentPage
			) {
		logger.info("페이징을 처리한 글 리스트 이동");
		//세션에서 로그인한 아이디 가져오기
		String userid = (String)session.getAttribute("userid");
				
		//글 개수 가져오기
		int totalCount = dao.ideaCount(userid);
		logger.info(Integer.toString(totalCount));
		
		
		PageNavigator navi = new PageNavigator(countPerPage, pagePerGroup, currentPage, totalCount);
		
		ArrayList<HashMap<String, Object>> list = dao.ideaListPaging(navi.getStartRecord(), countPerPage, userid);
		
		if(list.isEmpty()) {
			logger.info("아이디어 없음");
			return "redirect:noList";
		}
		logger.info("아이디어 있음");
		
		model.addAttribute("list", list); 			
		model.addAttribute("navi", navi);
		
		return "ideaList2";
	}
	
	
	@RequestMapping(value="noList", method=RequestMethod.GET)
	public String noList() {
		logger.info("아이디어가 없다는 jsp 출력");
		return "noList";
	}
	
	@RequestMapping(value="ideaReadForm", method=RequestMethod.GET)
	public String ideaReadForm(int infonum, HttpSession session, Model model) {
		logger.info("아이디어 읽기 이동");
		
		ArrayList<IdeaVO> list = dao.ideaRead(infonum);
		if(list == null) {
			logger.info("아이디어 읽기 실패");
			return "redirect:/ideaList";
		}
		logger.info("아이디어 읽기 성공");
		model.addAttribute("list", list);
		return "ideaReadForm";
	}
	
	@RequestMapping(value="ideaUpdate", method=RequestMethod.GET)
	public String ideaUpdate(IdeaVO vo, HttpSession session) {
		logger.info("아이디어 업데이트 폼 이동");
		String userid = (String)session.getAttribute("userid");
		vo.setUserid(userid);
		
		int cnt = dao.ideaUpdate(vo);
		if(cnt == 0) {
			logger.info("업데이트 실패");
			return "redirect:/";
		}
		else {
			logger.info("업데이트 성공");
		}
	
		return "ideaReadForm";
	}
	
	@RequestMapping(value="ideaRemove", method=RequestMethod.GET)
	public String ideaRemove(IdeaVO vo, HttpSession session) {
		logger.info("아이디어 삭제");
		
		String userid = (String)session.getAttribute("userid");
		vo.setUserid(userid);
		
		int cnt = dao.ideaRemove(vo);
		if(cnt == 0) {
			logger.info("삭제 실패");
			return "redirect:/";
		}
		logger.info("삭제 성공");
		return "redirect:ideaList";
	}
	
}
