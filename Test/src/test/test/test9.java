package test.test;

import java.util.Scanner;

public class test9 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("출력할 구구단 단수 입력 : ");
		int dansu;
		dansu = scan.nextInt();
		for(int i=1; i<10; i++) {
			int result = dansu*i;
			System.out.println(dansu+" x "+i+" = "+result);
		}
	}
}
