package test.main;

import test.mypac.Weapon;

public class MainClass06 {
	public static void main(String[] args) {

		//익명 클래스
		//extends Weapon 된 클래스
		//new Weapon() 은 익명클래스의 생성자를 call 하는 표현식
		Weapon w1 = new Weapon() { // class ? extends Weapon{
								   // @Override
								   //}
			
			@Override
			public void attack() {
				System.out.println("아무나 공격하자!");
			}
		};
		
		useWeapon(w1);
		
		useWeapon(new Weapon() {
			
			@Override
			public void attack() {
				System.out.println("지겹다 아무나 공격하자");
			}
		});
	}
	
	//Weapon type 의 참조값을 전달 받아서 사용하는 static 메소드
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
		w.attack();
	}
	
}
