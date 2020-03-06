package com.sesoc.idea.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sesoc.idea.vo.IdeaVO;


@Repository
public class IdeaDAO {
	
	@Autowired
	private SqlSession session;
	
	//아이디어 등록
	public int ideaWrite(IdeaVO vo) {
		int cnt = 0;
		try {
			IdeaMapper mapper = session.getMapper(IdeaMapper.class);
			cnt = mapper.ideaWrite(vo);	
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
		return cnt;
	}
	
	//아이디어 리스트
	public ArrayList<IdeaVO> ideaList(String userid){
		ArrayList<IdeaVO> list = null;
		try {	
			IdeaMapper mapper = session.getMapper(IdeaMapper.class);
			list = mapper.ideaList(userid);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//아이디어 읽기
	public ArrayList<IdeaVO> ideaRead(int infonum){
		ArrayList<IdeaVO> list = null;
		try {
			IdeaMapper mapper = session.getMapper(IdeaMapper.class);
			list = mapper.ideaRead(infonum);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//아이디어 업데이트
	public int ideaUpdate(IdeaVO vo) {
		int cnt = 0;
		try {
			IdeaMapper mapper = session.getMapper(IdeaMapper.class);
			cnt = mapper.ideaUpdate(vo);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return cnt;
		
	}

	//아이디어 삭제
	public int ideaRemove(IdeaVO vo) {
		int cnt = 0;
		try {
			IdeaMapper mapper = session.getMapper(IdeaMapper.class);
			cnt = mapper.ideaRemove(vo);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return cnt;		
	}
	
	//아이디어 개수
	public int ideaCount(String userid) {
		int cnt = 0;
		try {
			IdeaMapper mapper = session.getMapper(IdeaMapper.class);
			cnt = mapper.ideaCount(userid);			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	//페이징을 사용한 아이디어 리스트
	public ArrayList<HashMap<String, Object>> ideaListPaging(int startRecord, int countPerpage, String userid){
		ArrayList<HashMap<String, Object>> list = null;
		try {
			RowBounds rb = new RowBounds(startRecord, countPerpage);  
			IdeaMapper mapper = session.getMapper(IdeaMapper.class);
			list = mapper.ideaListPaging(rb, userid);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;	
	}
}
