package com.hw1.run;

import java.util.Arrays;

import com.hw1.model.vo.Employee;

public class Run {

	public static void main(String[] args) {
		Employee[] member = new Employee[3];
		
		member[0] = new Employee();
		member[1] = new Employee(1, "홍길동", 19, 'M', "01022223333", "서울 잠실");
		member[2] = new Employee(2, "강말순", "교육부", "강사", 20,
								'F', 1000000, 0.01, "01011112222", "서울 마곡");
		
		
		System.out.println("emp[0] : " + member[0].information());
		System.out.println("emp[1] : " + member[1].information());
		System.out.println("emp[2] : " + member[2].information());
		
		System.out.println("=====================================");
		
		
		member[0].setEmpNo(0);
		member[0].setEmpName("김말똥");
		member[0].setDept("영업부");
		member[0].setJob("팀장");
		member[0].setAge(30);
		member[0].setGender('M');
		member[0].setSalary(3000000);
		member[0].setBonusPoint(0.2);
		member[0].setPhone("01055559999");
		member[0].setAddress("전라도 광주");
		
		
		member[1].setDept("기획부");
		member[1].setJob("부장");
		member[1].setSalary(4000000);
		member[1].setBonusPoint(0.3);
		
		
		System.out.println("emp[0] : " + member[0].information());
		System.out.println("emp[1] : " + member[1].information());
		
		System.out.println("=====================================");
		
		double total = 0;
		for(int i = 0; i < member.length; i ++) {
			double result = (member[i].getSalary() + (member[i].getSalary() * member[i].getBonusPoint())) * 12;
			
			System.out.printf("%s의 연봉 : %.0f원\n", member[i].getEmpName(), result);
			
			total += result;
		}
		
		System.out.println("=====================================");
		
		System.out.printf("직원들의 연봉의 평균 : %.0f원", total/member.length);
	}
}
