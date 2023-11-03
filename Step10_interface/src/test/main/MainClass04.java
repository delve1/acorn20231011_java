package test.main;

import test.mypac.Drill;

public class MainClass04 {
	public static void main(String[] args) {
		useDrill(new Drill() {
			@Override
			public void hole() {	
				System.out.println("바닥에 구녕을 뚫어요!");
			}
		});
		
		useDrill(()->{
			System.out.println("천장에 구녕을 뚫어요!");
		}); 
		
		//javascript function
		//let f = ()=>{};
		//let f2 = function(){};
		
	}
	
	public static void useDrill(Drill d) {
		d.hole();
		d.hole();
	}
}
