package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.MemberDto;

public class MainClass08 {
public static void main(String[] args) {
	//MemberDto 객체를 담을수 있는 ArrayList 객체생성
	List<MemberDto> list=new ArrayList<MemberDto>();
	//MemberDto 객체에 회원의 정보 담기
	MemberDto dto1=new MemberDto();
	dto1.setNum(1);
	dto1.setName("김구라");
	dto1.setAddr("노량진");
	
	//생성자의 매개변수로 회원 한명의 정보 모두 전달해서 값 저장하기 
	MemberDto dto2 = new MemberDto(2, "해골", "원숭이");
	MemberDto dto3 = new MemberDto(3, "원숭이", "동물원");
	
	//ArrayList 에 담긴 회원정보를 반복문 돌면서 출력하기
	for(MemberDto tmp:list) {
		String result=String.format("번호: %d", "이름: %s", "주소: %d",
				tmp.getNum(), tmp.getName(), tmp.getAddr());
		System.out.println(result);
	}
}
}


