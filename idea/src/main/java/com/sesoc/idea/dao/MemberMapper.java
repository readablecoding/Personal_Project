package com.sesoc.idea.dao;

import com.sesoc.idea.vo.MemberVO;

public interface MemberMapper {
	
	//회원가입
	public int signup(MemberVO vo);
	
	//로그인
	public int login(MemberVO vo);
	
	//회원정보 수정
	public int memberUpdate(MemberVO vo);
	
}
