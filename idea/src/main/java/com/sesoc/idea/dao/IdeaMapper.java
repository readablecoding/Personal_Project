package com.sesoc.idea.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;

import com.sesoc.idea.vo.IdeaVO;

public interface IdeaMapper {
	
	//아이디어 등록
	public int ideaWrite(IdeaVO vo);
	
	//아이디어 리스트
	public ArrayList<IdeaVO> ideaList(String userid);
	
	//아이디어 읽기
	public ArrayList<IdeaVO> ideaRead(int infonum);
	
	//아이디어 업데이트
	public int ideaUpdate(IdeaVO vo);
	
	//아이디어 삭제
	public int ideaRemove(IdeaVO vo);

	//아이디어 개수
	public int ideaCount(String userid);
	
	//페이징을 사용한 아이디어 리스트
	public ArrayList<HashMap<String, Object>> ideaListPaging(RowBounds rb, String userid);
}
