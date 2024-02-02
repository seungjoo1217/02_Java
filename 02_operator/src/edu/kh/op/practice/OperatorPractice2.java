package edu.kh.op.practice;

import java.util.Scanner;

public class OperatorPractice2 {

	public void practice1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("당신의 나이는? : ");
		int input1 = sc.nextInt();
		
		String result1 = (input1 >= 20) ? "저는 성인 입니다?" : "저는 미성년 입니다";
		System.out.println(result1);
		
		boolean result2 = ((input1 >= 13) && (input1 <= 19));
		System.out.println("청소년 입니까? " + result2);
		
		boolean result3 = ((input1 >= 65) || (input1 <= 12));
		System.out.println("노인이거나 어린이 입니까? " + result3);
	}
}
