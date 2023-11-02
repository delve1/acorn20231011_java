package test.mypac;
/*
 * 사각형의 폭(width), 높이(height) 를 필드에 저장할수 있어야 합니다.
 * 필드에 저장된 폭과 높이를 이용해서 사각형의 넓이를 콘솔창에 출력하는 메소드를 가지고 있어야 합니다.
 * 필드와 메소드는 모두 non static 으로 만드세요.
 * 클래스명, 필드명, 메소드명은 여러분이 마음대로 정해 보세요.
 */
public class Square {
	//사각형의 폭과 높이를 저장할 필드 
	public double width;
	public double height;
	
	//면적을 출력하는 메소드
	public void Area(){
		//면적을 계산해서 
		double Area = width * height;
		//출력하기
		System.out.println("면적은 : "+Area+"");
	}
}
