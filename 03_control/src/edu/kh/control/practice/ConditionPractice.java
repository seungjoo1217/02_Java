package edu.kh.control.practice;

import java.util.Scanner;

public class ConditionPractice {

	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		System.out.print("숫자를 한 개 입력하세요 : ");
		int input = sc.nextInt();
		
		if(input > 0) {
			if(input%2 == 0) {
				System.out.println("짝수입니다.");
			}else {
				System.out.println("홀수입니다.");
			}
		}else {
			System.out.println("양수만 입력해주세요.");
		}
	}

	public void practice2() {
		System.out.print("국어점수 : ");
		int kor = sc.nextInt();
		System.out.print("수학점수 : ");
		int math = sc.nextInt();
		System.out.print("영어점수 : ");
		int eng = sc.nextInt();
		
		float avg = (float) ((kor + math + eng)/3);
		
		if(kor >= 40 && math >= 40 && eng >= 40 && avg >= 60) {
			System.out.println("국어 : " + kor);
			System.out.println("수학 : " + math);
			System.out.println("영어 : " + eng);
			System.out.println("합계 : " + (kor + math + eng));
			System.out.printf("평균 : %.1f\n",avg);
			System.out.println("축하합니다, 합격입니다!");
		} else {
			System.out.println("국어 : " + kor);
			System.out.println("수학 : " + math);
			System.out.println("영어 : " + eng);
			System.out.println("불합격입니다.");
		}
	}

	public void practice3() {
		System.out.print("1~12 사이의 정수 입력 : ");
		int input = sc.nextInt();
		
		int date = 0;
		
		
		switch(input) {
		case 1 :
			date = 31;
			System.out.printf("%d월은 %d일까지 있습니다.",input,date);
			break;
		case 2 :
			date = 28;
			System.out.printf("%d월은 %d일까지 있습니다.",input,date);
			break;
		case 3 :
			date = 31;
			System.out.printf("%d월은 %d일까지 있습니다.",input,date);
			break;
		case 4 :
			date = 30;
			System.out.printf("%d월은 %d일까지 있습니다.",input,date);
			break;
		case 5 :
			date = 31;
			System.out.printf("%d월은 %d일까지 있습니다.",input,date);
			break;
		case 6 :
			date = 30;
			System.out.printf("%d월은 %d일까지 있습니다.",input,date);
			break;
		case 7 :
			date = 31;
			System.out.printf("%d월은 %d일까지 있습니다.",input,date);
			break;
		case 8 :
			date = 31;
			System.out.printf("%d월은 %d일까지 있습니다.",input,date);
			break;
		case 9 :
			date = 30;
			System.out.printf("%d월은 %d일까지 있습니다.",input,date);
			break;
		case 10 :
			date = 31;
			System.out.printf("%d월은 %d일까지 있습니다.",input,date);
			break;
		case 11 :
			date = 30;
			System.out.printf("%d월은 %d일까지 있습니다.",input,date);
			break;
		case 12 :
			date = 31;
			System.out.printf("%d월은 %d일까지 있습니다.",input,date);
			break;
		}
		
		if(input <= 0 || input >= 13) {
			System.out.println(input + "월은 잘못 입력된 달입니다.");
		}
	}

	public void practice4() {
		System.out.print("키(m)를 입력해 주세요 : ");
		double input1 = sc.nextDouble();
		System.out.print("몸무게(kg)를 입력해 주세요 : ");
		double input2 = sc.nextDouble();

		double bmi = (input2/(input1*input1));
		System.out.println("BMI 지수 : " + bmi);
		String st = "";
		
		if(bmi < 18.5) {
			st = "저체중";
		}else if(bmi >= 18.5 && bmi < 23) {
			st = "정상체중";
		}else if(bmi >= 23 && bmi < 25) {
			st = "과체중";
		}else if(bmi >= 25 && bmi < 30) {
			st = "비만";
		}else if(bmi >= 30) {
			st = "고도 비만";
		}
		
		System.out.println(st);
	}

	public void practice5() {
		System.out.print("중간 고사 점수 : ");
		double input1 = sc.nextDouble();
		System.out.print("기말 고사 점수 : ");
		double input2 = sc.nextDouble();
		System.out.print("과제 점수 : ");
		double input3 = sc.nextDouble();
		System.out.print("출석 횟수 : ");
		double input4 = sc.nextDouble();
		
		double score = input1*0.2 + input2*0.3 + input3*0.3 + input4*0.2;
		
		if(score >= 70 && input4 > 20*0.3) {
			System.out.printf("중간 고사 점수(20) : %.1f\n",input1*0.2);
			System.out.printf("기말 고사 점수(30) : %.1f\n",input2*0.3);
			System.out.printf("과제 점수(30) : %.1f\n",input3*0.3);
			System.out.printf("출석 점수(20) : %.1f\n",input4*0.2);
			System.out.printf("총점 : %.1f\n",score);
			System.out.println("PASS");
		}else if(score < 70 && input4 > 20*0.3) {
			System.out.printf("중간 고사 점수(20) : %.1f\n",input1*0.2);
			System.out.printf("기말 고사 점수(30) : %.1f\n",input2*0.3);
			System.out.printf("과제 점수(30) : %.1f\n",input3*0.3);
			System.out.printf("출석 점수(20) : %.1f\n",input4*0.2);
			System.out.printf("총점 : %.1f\n",score);
			System.out.println("Fail [점수 미달]");
		}else if(input4 <= 20*0.3) {
			System.out.printf("Fail [출석 횟수 부족 (%.0f/20)\n",input4);
		}
	}

}
