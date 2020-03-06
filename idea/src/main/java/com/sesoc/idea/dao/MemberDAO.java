package com.sesoc.idea.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sesoc.idea.vo.MemberVO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession session;
	
	//회원가입
	public int signup(MemberVO vo) {
		int cnt = 0;
		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			cnt = mapper.signup(vo);	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return cnt;
		
	}
	
	//로그인
	public int login(MemberVO vo) {
		int cnt = 0;
		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			cnt = mapper.login(vo);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	//회원정보 수정
	public int memberUpdate(MemberVO vo) {
		int cnt = 0;
		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			cnt = mapper.memberUpdate(vo);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return cnt;	
	}
	
}
