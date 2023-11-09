package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.BookDto;

/*
 * 글 목록을 ArrayList 에 담아 보세요
 * 
 * 글 하나는
 * 글번호, 작성자, 제목 으로 이루어져 있다고 가정합니다.
 * 
 * 글 3개의 정보를 ArrayList 에 담고, 반복문 돌면서 담긴 내용을 출력해 보세요.
 * 
 * 글하나를 담을 dto 클래스를 알아서 만들어 보세요(클래스명, 필드명)
 */
public class QuizMain2 {
	public static void main(String[] args) {
		List<BookDto> list = new ArrayList<BookDto>();
		
		BookDto dto1 = new BookDto();
		dto1.setNum(1);
		dto1.setWt("김구라");
		dto1.setTt("체육1");
		
		BookDto dto2 = new BookDto(2,"김구라1","체육2");
		BookDto dto3 = new BookDto(3,"김구라2","체육3");
		
		for(BookDto tmp:list) {
			String result= String.format("번호: %d", "작성자: %s", "제목: %s",
					tmp.getNum(), tmp.getWt(), tmp.getTt());
			System.out.println(result);
		}
		}
}
