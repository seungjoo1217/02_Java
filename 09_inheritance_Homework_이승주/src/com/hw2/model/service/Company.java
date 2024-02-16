package com.hw2.model.service;

import com.hw2.model.dto.Employee;
import com.hw2.model.dto.Person;

public class Company implements ManagementSystem{
	
	private Employee[] employees;
	private int employeeCount;
	
	public Company() {}
	

	public Company(int count) {
		super();
		this.employees = new Employee[count];
	}


	@Override
	public void addPerson(Person person) {
		boolean flag = true;
		for(int i = 0; i < employees.length; i++) {
			if(employees[i] == null) {
				flag = false;
				employeeCount ++;
				employees[i] = (Employee) person;
				System.out.printf("직원이 추가되었습니다 - ID : %s, 이름 : %s, 직책 : %s\n",person.getId(), person.getName(), ((Employee)person).getPosition());
				break;
			}
		}
		if(flag) {
			System.out.println("인원이 모두 충원되었습니다.");
		}
		
	}

	@Override
	public void removePerson(String id) {
		boolean flag = true;
		for(int i = 0; i < employeeCount; i++) {
			if(employees[i].getId().equals(id)) {
				employeeCount --;
				flag = false;
				System.out.printf("직원이 삭제되었습니다 - ID : %s, 이름 : %s, 직책 : %s\n",employees[i].getId(), employees[i].getName(), employees[i].getPosition());
				for(int j = i; j < employeeCount-i-1; j++) {
					employees[j] = employees[j+1];
				}
				break;
			}
		}
		if(flag) {
			System.out.println("해당 ID를 가진 직원을 찾을 수 없습니다.");
		}
		
	}

	@Override
	public void displayPerson() {
		System.out.println("전체 직원 명단 : ");
		for(int i = 0; i < employeeCount; i++) {
			System.out.println(employees[i].getInfo());
		}
		
	}


	public Employee[] getEmployees() {
		return employees;
	}


	public void setEmployees(Employee[] employees) {
		this.employees = employees;
	}


	public int getEmployeeCount() {
		return employeeCount;
	}


	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}

	
}
