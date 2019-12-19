package days.ui;

import java.util.ArrayList;
import java.util.Scanner;

import days.dao.DaysDAO;
import days.vo.DaysVO;

public class DaysUI 
{
		//변수
		Scanner scan = new Scanner(System.in);
		DaysDAO dao = new DaysDAO();
		

		// 기본생성자
		public DaysUI() 
		{
			while(true)
			{
				int n = menuPrint();
				switch(n)
				{
					case 1:
						write();
						break;
					case 2:
						update();
						break;
					case 3:
						read();
						break;
					case 4:
						search();
						break;
					case 5:
						delete();
						break;
					case 0:
					System.out.println("프로그램을 종료합니다.");
					return;				
				}
			}
		}

		// 메뉴
		public int menuPrint() {
			System.out.println("[날짜 모음]");
			System.out.println("이름과 해당날짜를 보여주는 프로그램입니다.");
			System.out.println("1.저장");
			System.out.println("2.수정");
			System.out.println("3.글 읽기");
			System.out.println("4.검색");
			System.out.println("5.삭제");
			System.out.println("0.프로그램 종료");
			System.out.println();
			int n = 0;

			while (true) {
				try {
					System.out.print("번호 선택 > ");
					n = scan.nextInt();
					if (n < 0 || n > 5) {
						System.out.println("0 ~ 6 중에서 입력해주세요.");
						continue;
					}
				} catch (Exception e) {
					System.out.println("숫자를 제대로 입력해주세요.");
					scan.nextLine();
					continue;
				}

				break;
			} // while
			System.out.println();
			return n;
		}// menuPrint()

		// 메소드 6개
		
		//1.저장
		public void write()
		{
			
			System.out.println("[저장]");
			String id, title, sdate, edate;
			int cnt;
			scan.nextLine(); //기존에 번호를 입력받아 엔터가 남아있으니 제거하기
			
			while(true)
			{
				try
				{
					System.out.print("ID > ");
					id = scan.nextLine();
					System.out.print("제목 > ");
					title = scan.nextLine();
					System.out.print("시작일(yy-mm-dd) > ");
					sdate = scan.nextLine();
					System.out.print("종료일(yy-mm-dd) > ");
					edate = scan.nextLine();
				}
				catch(Exception e)
				{
					System.out.println("제대로 입력해주세요.");
					scan.nextLine();
					continue;
				}
				break;
			}
			DaysVO vo = new DaysVO(id, title, sdate, edate);
			cnt = dao.writeDays(vo);
			if(cnt == 1)
			{
				System.out.println("저장되었습니다.");
			}
			else
			{
				System.out.println("저장 실패했습니다.");
			}
			System.out.println();
		}//write()
		
		//2.수정
		public void update()
		{
			System.out.println("[수정]");
			int num;
			String title, sdate, edate;
			int cnt = 0;
			
			while(true)
			{
				try
				{
					System.out.print("바꿀 번호 > ");
					num = scan.nextInt();
					scan.nextLine();
					System.out.print("제목 > ");
					title = scan.nextLine();
					System.out.print("시작일 > ");
					sdate = scan.nextLine();
					System.out.print("종료일 > ");
					edate = scan.nextLine();
					
				}
				catch(Exception e)
				{
					System.out.println("제대로 입력해주세요.");
					scan.nextLine();
					continue;
				}
				break;
			}
			
			 DaysVO vo = new DaysVO(num, title, sdate, edate);
			cnt = dao.updateDays(vo);
			if(cnt == 0)
			{
				System.out.println("글이 존재하지 않습니다.");
			}
			else
			{
				System.out.println("수정되었습니다.");
			}
			System.out.println();		
		}
		
		//3.글 읽기
		public void read()
		{
			int n;
			ArrayList<DaysVO> list = null;
			
			System.out.println("[글 읽기]");
			System.out.println("글 번호를 입력하세요. 0을 입력하면 전체 글 읽기");
			
			while(true)
			{
				try
				{
					System.out.print("번호 > ");
					n = scan.nextInt();
				}
				catch(Exception e)
				{
					System.out.println("숫자를 입력해주세요.");
					scan.nextLine();
					continue;
				}
				break;
			}
			
			list = dao.readDays(n);
			if(list == null || list.size() == 0)
			{
				System.out.println("글이 존재하지 않습니다.");
			}
			else
			{	
				
				for(int i = 0; i < list.size(); i++)
				{
					System.out.println(list.get(i));
				}
				
				
			}
			System.out.println();
		}
		
		
		
		//4.검색
		public void search()
		{
			System.out.println("[검색]");
			System.out.println("1.제목으로 검색");
			System.out.println("2.날짜로 검색");
			int type;
			String word = null;
			ArrayList<DaysVO> list = null;
			
			while(true)
			{
				try
				{
					System.out.print("번호 선택 > ");
					type = scan.nextInt();	
					if(type < 1 || type > 2)
					{
						System.out.println("1 ~ 2 중에서 입력하세요.");
						continue;
					}
					scan.nextLine();
					if(type == 1)
					{
						System.out.print("검색어 > ");
						word = scan.nextLine();	
					}
					if(type == 2)
					{
						System.out.print("날짜입력(yy/mm/dd) > ");
						word = scan.nextLine();	
					}
						
				}
				catch(Exception e)
				{
					System.out.println("제대로 입력하세요.");
					scan.nextLine();
					continue;
				}
				break;
			}//while
			
			list = dao.searchDays(type, word);
			if(list == null || list.size() == 0)
			{
				System.out.println("검색 결과가 없습니다.");
			}
			else
			{
				for(DaysVO vo : list)
				{
					System.out.println(vo);
				}
			}
			System.out.println();	
		}
		
		//5.삭제
		public void delete()
		{
			int n;
			int cnt = 0;
			System.out.println("[삭제]");
			while(true)
			{
				try
				{
					System.out.print("번호 > ");
					n = scan.nextInt();
				}
				catch(Exception e)
				{
					System.out.println("숫자를 입력해주세요.");
					scan.nextLine();
					continue;
				}
				break;
			}
			cnt = dao.deleteDays(n);
			if(cnt == 0)
			{
				System.out.println("해당하는 번호의 글이 없습니다.");
			}
			else
			{
				System.out.println("삭제되었습니다.");
			}
			System.out.println();
		}
		
	
}
