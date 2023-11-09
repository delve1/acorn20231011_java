package test.main;

import java.util.HashSet;
import java.util.Set;

import javax.lang.model.type.IntersectionType;

public class MainClass14 {
	public static void main(String[] args) {
		Set<Integer> set1 =new HashSet<>();
		set1.add(10);
		set1.add(20);
		set1.add(30);
		
		Set<Integer> set2 =new HashSet<>();
		set2.add(30);
		set2.add(40);
		set2.add(50);
		
		// set 과 set2의 교집합 구하기
		Set<Integer> intersaction = new HashSet(set1);
		intersaction.retainAll(set2);
		
		// set1 과 set2 의 합집합 구하기
		Set<Integer> union= new HashSet<>(set1);
		union.addAll(set2);
		
		// set1 과 set2 의 차집합 (se1 - set2)누르기
		Set<Integer> difference=new HashSet<>(set1);
		difference.removeAll(set2);
	}
	}

