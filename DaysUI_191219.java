package days.ui;

import java.util.ArrayList;
import java.util.Scanner;

import days.dao.DaysDAO;
import days.vo.DaysVO;

public class DaysUI 
{
		//����
		Scanner scan = new Scanner(System.in);
		DaysDAO dao = new DaysDAO();
		

		// �⺻������
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
					System.out.println("���α׷��� �����մϴ�.");
					return;				
				}
			}
		}

		// �޴�
		public int menuPrint() {
			System.out.println("[��¥ ����]");
			System.out.println("�̸��� �ش糯¥�� �����ִ� ���α׷��Դϴ�.");
			System.out.println("1.����");
			System.out.println("2.����");
			System.out.println("3.�� �б�");
			System.out.println("4.�˻�");
			System.out.println("5.����");
			System.out.println("0.���α׷� ����");
			System.out.println();
			int n = 0;

			while (true) {
				try {
					System.out.print("��ȣ ���� > ");
					n = scan.nextInt();
					if (n < 0 || n > 5) {
						System.out.println("0 ~ 6 �߿��� �Է����ּ���.");
						continue;
					}
				} catch (Exception e) {
					System.out.println("���ڸ� ����� �Է����ּ���.");
					scan.nextLine();
					continue;
				}

				break;
			} // while
			System.out.println();
			return n;
		}// menuPrint()

		// �޼ҵ� 6��
		
		//1.����
		public void write()
		{
			
			System.out.println("[����]");
			String id, title, sdate, edate;
			int cnt;
			scan.nextLine(); //������ ��ȣ�� �Է¹޾� ���Ͱ� ���������� �����ϱ�
			
			while(true)
			{
				try
				{
					System.out.print("ID > ");
					id = scan.nextLine();
					System.out.print("���� > ");
					title = scan.nextLine();
					System.out.print("������(yy-mm-dd) > ");
					sdate = scan.nextLine();
					System.out.print("������(yy-mm-dd) > ");
					edate = scan.nextLine();
				}
				catch(Exception e)
				{
					System.out.println("����� �Է����ּ���.");
					scan.nextLine();
					continue;
				}
				break;
			}
			DaysVO vo = new DaysVO(id, title, sdate, edate);
			cnt = dao.writeDays(vo);
			if(cnt == 1)
			{
				System.out.println("����Ǿ����ϴ�.");
			}
			else
			{
				System.out.println("���� �����߽��ϴ�.");
			}
			System.out.println();
		}//write()
		
		//2.����
		public void update()
		{
			System.out.println("[����]");
			int num;
			String title, sdate, edate;
			int cnt = 0;
			
			while(true)
			{
				try
				{
					System.out.print("�ٲ� ��ȣ > ");
					num = scan.nextInt();
					scan.nextLine();
					System.out.print("���� > ");
					title = scan.nextLine();
					System.out.print("������ > ");
					sdate = scan.nextLine();
					System.out.print("������ > ");
					edate = scan.nextLine();
					
				}
				catch(Exception e)
				{
					System.out.println("����� �Է����ּ���.");
					scan.nextLine();
					continue;
				}
				break;
			}
			
			 DaysVO vo = new DaysVO(num, title, sdate, edate);
			cnt = dao.updateDays(vo);
			if(cnt == 0)
			{
				System.out.println("���� �������� �ʽ��ϴ�.");
			}
			else
			{
				System.out.println("�����Ǿ����ϴ�.");
			}
			System.out.println();		
		}
		
		//3.�� �б�
		public void read()
		{
			int n;
			ArrayList<DaysVO> list = null;
			
			System.out.println("[�� �б�]");
			System.out.println("�� ��ȣ�� �Է��ϼ���. 0�� �Է��ϸ� ��ü �� �б�");
			
			while(true)
			{
				try
				{
					System.out.print("��ȣ > ");
					n = scan.nextInt();
				}
				catch(Exception e)
				{
					System.out.println("���ڸ� �Է����ּ���.");
					scan.nextLine();
					continue;
				}
				break;
			}
			
			list = dao.readDays(n);
			if(list == null || list.size() == 0)
			{
				System.out.println("���� �������� �ʽ��ϴ�.");
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
		
		
		
		//4.�˻�
		public void search()
		{
			System.out.println("[�˻�]");
			System.out.println("1.�������� �˻�");
			System.out.println("2.��¥�� �˻�");
			int type;
			String word = null;
			ArrayList<DaysVO> list = null;
			
			while(true)
			{
				try
				{
					System.out.print("��ȣ ���� > ");
					type = scan.nextInt();	
					if(type < 1 || type > 2)
					{
						System.out.println("1 ~ 2 �߿��� �Է��ϼ���.");
						continue;
					}
					scan.nextLine();
					if(type == 1)
					{
						System.out.print("�˻��� > ");
						word = scan.nextLine();	
					}
					if(type == 2)
					{
						System.out.print("��¥�Է�(yy/mm/dd) > ");
						word = scan.nextLine();	
					}
						
				}
				catch(Exception e)
				{
					System.out.println("����� �Է��ϼ���.");
					scan.nextLine();
					continue;
				}
				break;
			}//while
			
			list = dao.searchDays(type, word);
			if(list == null || list.size() == 0)
			{
				System.out.println("�˻� ����� �����ϴ�.");
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
		
		//5.����
		public void delete()
		{
			int n;
			int cnt = 0;
			System.out.println("[����]");
			while(true)
			{
				try
				{
					System.out.print("��ȣ > ");
					n = scan.nextInt();
				}
				catch(Exception e)
				{
					System.out.println("���ڸ� �Է����ּ���.");
					scan.nextLine();
					continue;
				}
				break;
			}
			cnt = dao.deleteDays(n);
			if(cnt == 0)
			{
				System.out.println("�ش��ϴ� ��ȣ�� ���� �����ϴ�.");
			}
			else
			{
				System.out.println("�����Ǿ����ϴ�.");
			}
			System.out.println();
		}
		
	
}
