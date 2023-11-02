package test.mypac;

public class Member {
	//필드
	public int num;
	public String name;
	public String addr;
	
	//생성자 만들면 default 생성자가 사라짐
	//int, String, String type 을 전달 받는 생성자
	//생성자 overloading 되어있다
	//지역변수 
	public Member(int num, String name, String addr) {
		this.num=num;
		this.name=name;
		this.addr=addr;
	};
	//default 생성자
	public Member() {};
	
	//메소드
	public void println() {
		System.out.println("번호:"+num+" 이름:"+name+" 주소:"+addr);
	}
}
