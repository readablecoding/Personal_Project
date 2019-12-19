package days.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import days.vo.DaysVO;

public class DaysDAO 
{
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	//����
	public int writeDays(DaysVO vo)
	{
		SqlSession ss = null;
		int cnt = 0;
		try
		{
			ss = factory.openSession();
			DaysMapper mapper = ss.getMapper(DaysMapper.class);
			cnt = mapper.writeDays(vo);
			ss.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(ss != null)
			{
				ss.close();
			}
		}
		return cnt;
		
	}//writeLink()

	
	//����
	public int updateDays(DaysVO vo)
	{
		SqlSession ss = null;
		int cnt = 0;
		try
		{
			ss = factory.openSession();
			DaysMapper mapper = ss.getMapper(DaysMapper.class);
			cnt = mapper.updateDays(vo);
			ss.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(ss != null)
			{
				ss.close();
			}
		}
		return cnt;
	}
	
	//�� �б�
	public ArrayList<DaysVO> readDays(int n)
	{
		SqlSession ss = null;
		ArrayList<DaysVO> list = null;
		try
		{
			ss = factory.openSession();
			DaysMapper mapper = ss.getMapper(DaysMapper.class);
			list = mapper.readDays(n);
			ss.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(ss != null)
			{
				ss.close();
			}
		}
		return list;
	}
	

	//�˻�
	public ArrayList<DaysVO> searchDays(int type, String word)
	{
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("word", word);
		
		SqlSession ss = null;
		ArrayList<DaysVO> list = null;
		try
		{
			ss = factory.openSession();
			DaysMapper mapper = ss.getMapper(DaysMapper.class);
			list= mapper.searchDays(map);
			ss.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(ss != null)
			{
				ss.close();
			}
		}
		return list;
	}
	
	//����
	public int deleteDays(int n)
	{
		SqlSession ss = null;
		int cnt = 0;
		try
		{
			ss = factory.openSession();
			DaysMapper mapper = ss.getMapper(DaysMapper.class);
			cnt = mapper.deleteDays(n);
			ss.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(ss != null)
			{
				ss.close();
			}
		}
		return cnt;
	}
	
	
}