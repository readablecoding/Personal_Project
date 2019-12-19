package days.dao;

import java.util.ArrayList;
import java.util.HashMap;
import days.vo.DaysVO;

public interface DaysMapper
{
	//저장
	public int writeDays(DaysVO vo);
	
	//수정
	public int updateDays(DaysVO vo);
	
	//글 읽기
	public ArrayList<DaysVO> readDays(int n);
	
	//검색
	public ArrayList<DaysVO> searchDays(HashMap<String, Object> map);
	
	//삭제
	public int deleteDays(int n);
		
}
