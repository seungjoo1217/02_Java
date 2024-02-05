package edu.kh.control.practice;

import java.util.Scanner;

public class LoopPractice {

Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		
		if(input < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
			}else {
				for(int i = 1; i <= input; i++) {
					System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	public void practice2() {
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		
		if(input < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
			}else {
				for(int i = input; i >= 1; i--) {
					System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	public void practice3() {
		System.out.print("정수를 하나 입력하세요 : ");
		int input = sc.nextInt();
		
		int sum = 0;
		for(int i = 1; i <= input; i++) {
			if(i == input) {
				System.out.print(i);
				sum += i;
			}else {
				System.out.print(i + " + ");
				sum += i;
			}
			
		}
		System.out.println(" = " + sum);
	}

	public void practice4() {
		System.out.print("첫 번째 숫자 : ");
		int input1 = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int input2 = sc.nextInt();
		
		if(input1 < 1 || input2 < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}else {
			if(input1 > input2) {
				for(int i = input2; i <= input1; i++) {
					System.out.print(i + " ");
				}
			}else {
				for(int i = input1; i <= input2; i++) {
					System.out.print(i + " ");
				}
			}
		}
		System.out.println();
	}

	public void practice5() {
		System.out.print("숫자 : ");
		int input = sc.nextInt();
		
		System.out.println("==== "+input + "단 ====");
		
		for(int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d\n",input,i,input*i);
		}
	}

	public void practice6() {
		System.out.print("숫자 : ");
		int input = sc.nextInt();
		
		if(input < 2 || input > 9) {
			System.out.println("2~9 사이 숫자만 입력해주세요.");
		}else {
			for(int j = input; j <= 9; j++) {
				System.out.println("==== "+ j + "단 ====");
				
				for(int i = 1; i <= 9; i++) {
					System.out.printf("%d * %d = %d\n",j,i,j*i);
				}
			}
		}
	}

	public void practice7() {
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for(int i = 1; i <= input; i ++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void practice8() {
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for(int i = input; i >= 1; i--) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void practice9() {
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for(int i = 1; i <= input; i++) {
			for(int j = input-i; j >= 1 ; j--) {
				System.out.print(" ");
				
				}
			for(int z = 1; z <= i; z++) {
				System.out.print("*");
			}
				System.out.println();
		}
	}

	public void practice10() {
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for(int i = 1; i <= input; i ++) {
			for(int j = 1; j <= i; j ++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int z = input-1; z >= 1; z--) {
			for(int j = z; j >= 1; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void practice11() {
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for(int i = 1; i <= input; i++) {
			for(int j = input-i; j >= 1 ; j--) {
				System.out.print(" ");
				
				}
			for(int z = 1; z <= i*2-1; z++) {
				System.out.print("*");
			}
				System.out.println();
		}
	}

	public void practice12() {
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for(int i = 1; i<= input; i++) {
			if(i == 1 || i == input) {
				for(int j = 1; j <= input; j++) {
					System.out.print("*");					
				}
			}else {
				System.out.print("*");
				for(int j = 1; j <= input-2; j++) {
					System.out.print(" ");
				}
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void practice13() {
		System.out.print("자연수 하나를 입력하세요 : ");
		int input = sc.nextInt();
		
		int count = 0;
		for(int i = 1; i <= input; i++) {
			if(i % 2 == 0 || i % 3 == 0) {
				System.out.print(i + " ");
			}
			if(i % 2 == 0 && i % 3 == 0) {
				count ++;
			}
		}
		System.out.println();
		System.out.println("count : "+ count);
	}
}
