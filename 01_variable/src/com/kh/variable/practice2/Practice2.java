package com.kh.variable.practice2;

import java.util.Scanner;

public class Practice2 {

	public void ex1() {
		
		Scanner sc = new Scanner(System.in);
		Practice2 pr2 = new Practice2();
		
		System.out.print("문자 : ");
		String ch1 = sc.next();
		
		int num = (int)ch1.charAt(0);
		
		
		System.out.printf("%s unicode : %d\n", ch1, num );
	}
}
