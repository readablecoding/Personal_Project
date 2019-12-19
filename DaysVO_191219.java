package days.vo;

public class DaysVO 
{
	//변수
	private int num;
	private String id;
	private String title;
	private String sdate;
	private String edate;
	private String wrdate;
	

	//생성자
	public DaysVO() 
	{
		
	}

	public DaysVO(String id, String title, String sdate, String edate) {
		super();
		this.id = id;
		this.title = title;
		this.sdate = sdate;
		this.edate = edate;
	}
	
	public DaysVO(int num, String title, String sdate, String edate) {
		super();
		this.num = num;
		this.title = title;
		this.sdate = sdate;
		this.edate = edate;
	}

	//getter, setter
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public String getWrdate() {
		return wrdate;
	}

	public void setWrdate(String wrdate) {
		this.wrdate = wrdate;
	}

	//toString
	@Override
	public String toString() {
		return " 번호: " + num + ", 아이디: " + id + ", 제목: " + title + ", 시작일: " + sdate + ", 종료일: " + edate
				+ ", 작성일: " + wrdate;
	}
	
	
	
}
