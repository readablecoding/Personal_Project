package days.dao;

import java.util.ArrayList;
import java.util.HashMap;
import days.vo.DaysVO;

public interface DaysMapper
{
	//����
	public int writeDays(DaysVO vo);
	
	//����
	public int updateDays(DaysVO vo);
	
	//�� �б�
	public ArrayList<DaysVO> readDays(int n);
	
	//�˻�
	public ArrayList<DaysVO> searchDays(HashMap<String, Object> map);
	
	//����
	public int deleteDays(int n);
		
}
