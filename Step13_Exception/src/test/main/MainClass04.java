package test.main;

public class MainClass04 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작 되었습니다.");
		
		try {
			//스레드를 일정시간 지연시키기(mili second 단위로 숫자를 전달하면 된다)
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();//에러의 발생근원지를 찾아서 단계별로 에러 출력
		}
		
		System.out.println("main 메소드가 종료 됩니다.");
		
	}

}
