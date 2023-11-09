package test.mypac;

public class BookDto {
	private int num;
	private String wt;
	private String tt;
	
	public BookDto() {}; //default 생성자
	
	public BookDto(int num, String wt, String tt) {
		super();
		this.num = num;
		this.wt = wt;
		this.tt = tt;
	}

	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWt() {
		return wt;
	}

	public void setWt(String wt) {
		this.wt = wt;
	}

	public String getTt() {
		return tt;
	}

	public void setTt(String tt) {
		this.tt = tt;
	}
	
	
}
