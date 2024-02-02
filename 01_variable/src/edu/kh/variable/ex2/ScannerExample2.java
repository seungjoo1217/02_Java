package edu.kh.variable.ex2;

import java.util.Scanner;

public class ScannerExample2 {

	public static void main(String[] args) {
		
		// 사칙연산 계산기
		// -> 두 실수를 입력받아 사칙연산 결과를 모두 출력
		// -> 단, 출력된 결과값은 소수점 이하 2째자리까지만 표현
		
		// 정수 : sc.nextInt();
		// 실수 : sc.nextdouble();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("실수 1 입력 : ");
		double db1 = sc.nextDouble();
		
		System.out.print("실수 2 입력 : ");
		double db2 = sc.nextDouble();
		
		// +, - , &, /
		
		System.out.printf("%.2f + %.2f = %.2f\n", db1, db2, db1+db2);
		System.out.printf("%.2f - %.2f = %.2f\n", db1, db2, db1-db2);
		System.out.printf("%.2f * %.2f = %.2f\n", db1, db2, db1*db2);
		System.out.printf("%.2f / %.2f = %.2f\n", db1, db2, db1/db2);
	}
}
