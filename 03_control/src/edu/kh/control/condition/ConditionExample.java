package edu.kh.control.condition;

import java.util.Scanner;

public class ConditionExample { // 기능 제공용 클래스
	
	Scanner sc = new Scanner(System.in);
	
	public void ex1() {
		
		// if문
		// 조건식이 true 일때만 내부 코드 수행
		
		/*
		 * [작성법]
		 * if(조건식) {
		 * 		조건식이 true 일 때 수행할 코드
		 * }
		 * 
		 * 
		 * */
		
		// 입력받은 정수가 양수인지 검사
		// 양수라면 "양수입니다" 출력
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		if(input > 0) {
			System.out.println("양수입니다");
		}
		
		if(input <= 0) {
			System.out.println("양수가 아니다");
		}
		
		
	}
	
	
	public void ex2() {
		
		// if - else 문
		// 조건식 결과가 true 면 if문,
		// false면 else 구문이 수행됨
		
		/*
		 * [작성법]
		 * if(조건식){
		 * 		조건식이 true일 때 수행될 코드
		 * } else {
		 * 		조건식이 false일 때 수행될 코드
		 * }
		 * 
		 * 
		 * 
		 * */
		
		
		// 홀짝 검사
		// 입력받은 정수값이 홀수이면 "홀수입니다"출력
		// 0이면 "0입니다"
		// 짝수이면 "짝수입니다" 출력
		// else if 사용 x, 중첩 if 문 사용하기
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		if(input != 0) {
			if(input % 2 == 1) {
				System.out.println("홀수입니다");
			} else {
				System.out.println("짝수입니다");
			}
		} else { 
			System.out.println("0입니다");
		}
	}

	
	public void ex3() {
		// 양수, 음수, 0 판별
		// if(조건식) - else if(조건식) - else
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		if(input > 0) {	
			System.out.println("양수 입니다");
			
		} else if(input < 0) { // 바로 위에있는 if문이 만족되지 않은 경우 수행
			System.out.println("음수 입니다");
			
		} else {
			System.out.println("0 입니다");
		}
		
		
	}

	
	public void ex4() {
		// 달(month)을 입력받아 해당 달에 맞는 계절 출력
		// 단, 겨울일때 온도가 -15도 이하 "한파 경보", -12이하 "한파 주의보"
		// 여름일떄 온도가 35도 이상 " 폭염 경보", 33도 이상 "폭염 주의보"
		// 1~12 사이가 아닐 땐 "해당하는 계절이 없습니다"출력
		// 1,2,12 겨울
		// 3~5 봄
		// 6~8 여름
		// 9~11 가을
		

	
		
		
		System.out.print("달을 입력해주세요 : ");
		int input = sc.nextInt();
	
		String season; // 아래 조건문 수행 결과를 저장할 변수 선언
		
		if(input ==12 || input == 1 || input == 2) {
			season = "겨울";
			
			System.out.print("온도를 입력해주세요 : ");
			int temperature = sc.nextInt();
			
			if(temperature <= -12) {
				season += " 한파주의보";
			}else if(temperature <= -15) {
				season += " 한파경보";
			}
		}else if(input >= 3 && input <= 5) {
			season = "봄";
			
		}else if(input >= 6 && input <= 8) {
			season = "여름";
			
			System.out.print("온도를 입력해주세요 : ");
			int temperature = sc.nextInt();
			
			if(temperature >= 33) {
				season += " 폭염주의보";
			}else if(temperature >= 35) {
				season += " 폭염경보";
			}
		}else if(input >= 9 && input <= 11) {
			season = "가을";
			
		}else {
			season = "해당하는 계절이 없습니다";
		}
		
		
		System.out.println(season);
	}
	
	
	public void ex5() {
		
		System.out.print("나이를 입력해주세요 : ");
		int input = sc.nextInt();
		
		if(input <= 13) {
			System.out.println("어린이 입니다.");
		
		}else if(input > 13 && input <= 19) {
			System.out.println("청소년 입니다.");
			
		}else {
			System.out.println("성인 입니다.");
		}
	}

	
	public void ex6() {
		
		System.out.print("점수를 입력해주세요 : ");
		int input = sc.nextInt();
	
		String score = null;
		
		if(input >= 90) {
			score = "A";

		}else if(input >= 80 && input < 90) {
			score = "B";
			
		}else if(input >= 70 && input < 80) {
			score = "C";
			
		}else if(input >= 60 && input < 70) {
			score = "D";
			
		}else if(input < 60) {
			score = "F";
			
		}else if(input > 100 || input < 0){
			score = "잘못 입력하셨습니다";
		}
		
		
		System.out.println(score);

	}

	
	public void ex7() {
		
		System.out.print("나이를 입력해주세요 : ");
		int input = sc.nextInt();
	
		String age = null;
		
		if(input >= 12) {
			System.out.print("키를 입력해주세요 : ");
			Double height = sc.nextDouble();
			
			if(height >= 140) {
				age = "탑승가능";
			}else {
				age = "적정 키가 아닙니다.";
			}

		}else if(input < 12) {
			age = "적정 연령이 아닙니다.";
			
		}else if(input < 0 || input > 100) {
			age = "잘못 입력 하셨습니다";
			
		}
		
		System.out.println(age);
		
	}

	
	public void ex8() {
		
		System.out.print("나이를 입력해주세요 : ");
		int input1 = sc.nextInt();
		System.out.print("키를 입력해주세요 : ");
		Double input2 = sc.nextDouble();
	
		String output = null;
		
		if(input1 >= 12 && input2 >= 140) {
			output = "탑승 가능";
		}else if(input1 >= 12 && input2 < 140) {
			output = "나이는 적절하나, 키가 적절치 않음";
			
		}else if(input1 < 12 && input2 >= 140) {
			output = "키는 적절하나, 나이는 적절치 않음";
			
		}else if(input1 < 12 && input2 < 140) {
			output = "나이와 키 모두 적절치 않음";
			
		}else if(input1 < 0 || input1 > 100) {
			output = "나이를 잘못 입력 하셨습니다";
			
		}else if(input2 < 0 || input2 > 250) {
			output = "키를 잘못 입력 하셨습니다";
			
		}
		
		
		System.out.println(output);
	}
	
	
	
	
	
}
