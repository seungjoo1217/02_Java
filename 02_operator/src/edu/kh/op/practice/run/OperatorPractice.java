package edu.kh.op.practice.run;

import java.util.Scanner;

public class OperatorPractice {

	public void practice1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("인원 수 : ");
		int input1 = sc.nextInt();		
		
		System.out.print("사탕 개수 : ");
		int input2 = sc.nextInt();
		
		System.out.println("1인당 사탕 개수 : " + (input2 / input1));
		System.out.println("남는 사탕 개수 : " + (input2 % input1));
	}
	
	public void practice2() {
		Scanner sc = new Scanner(System.in);
	
		System.out.print("이름 : ");
		String input1 = sc.next();
		
		System.out.print("학년(정수만) : ");
		int input2 = sc.nextInt();
		
		System.out.print("반(정수만) : ");
		int input3 = sc.nextInt();
		
		System.out.print("번호 : ");
		int input4 = sc.nextInt();
		
		System.out.print("성별(남학생/여학생) : ");
		String input5 = sc.next();
		
		System.out.print("성적(소수점 아래 둘째 자리까지) : ");
		double input6 = sc.nextDouble();
		
		System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f이다.\n",input2,input3,input4,input1,input5,input6);
		
	}
	//세 과목의 점수가 각각 40점 이상이면서 평균이 50점 이상일때 합격 아니면 불합격

	public void practice3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 : ");
		double input1 = sc.nextDouble();
		
		System.out.print("영어 : ");
		double input2 = sc.nextDouble();
		
		System.out.print("수학 : ");
		double input3 = sc.nextDouble();
		
		System.out.println("합계 : " + (int)(input1 + input2 + input3));
		System.out.printf("평균 : %.1f\n", ((input1 + input2 + input3)/3));
		
		String st1 = ((input1 >= 40)&& (input2>= 40) && (input3 >= 40)) && (((input1+input2+input3)/3) >=60) ? "합격입니다" : "불합격입니다";
		System.out.println(st1);
	}
}
