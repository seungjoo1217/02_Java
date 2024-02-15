package com.hw1.run;

import java.util.Scanner;

import com.hw1.model.vo.Employee;
import com.hw1.model.vo.Student;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		Student[] std = new Student[3];
		
		{
			std[0] = new Student("홍길동", 20, 178.2, 70.0, 1, "정보시스템공학과");
			std[1] = new Student("김말똥", 21, 187.3, 80.0, 2, "경영학과");
			std[2] = new Student("강개순", 23, 167.0, 45.0, 4, "정보통신학과");
		}
		
		// 학생 정보 모두 출력
		// 향상된 for문
		for(Student st : std) {
			System.out.println(st.information());
		}
		
		System.out.println("================================================");
		
		
		Employee[] emp = new Employee[10];
		
		int count = 0;
		if(count == 10) {
			System.out.println("더 이상 추가할 수 없습니다.");
		} else {
			while(true) {
				char input = 'a';
				for(int i = 0; i < emp.length; i++) {
					System.out.print("이름을 입력해 주세요 : ");
					String name = sc.next();
					
					System.out.print("나이를 입력해 주세요 : ");
					int age = sc.nextInt();
					
					System.out.print("신장을 입력해 주세요 : ");
					double height = sc.nextDouble();
					
					System.out.print("몸무게를 입력해 주세요 : ");
					double weight = sc.nextDouble();
					
					System.out.print("급여를 입력해 주세요 : ");
					int salary = sc.nextInt();
					
					System.out.print("부서 입력해 주세요 : ");
					String dept = sc.next();
					
					emp[i] = new Employee(name, age, height, weight, salary, dept);
					count ++;
					
					System.out.print("계속 추가하시겠습니까? (y/n) : ");
					input = sc.next().charAt(0);
					
					if(input != 'y' && input != 'Y') break;
				}
				if(input != 'y' && input != 'Y') break;
			}
		}	

		
		
		for(int i = 0; i < count; i++) {
			System.out.println(emp[i].information());
		}
		

	}
}
