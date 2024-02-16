package com.hw2.run;

import com.hw2.model.dto.Employee;
import com.hw2.model.dto.Person;
import com.hw2.model.dto.Prisoner;
import com.hw2.model.service.Company;
import com.hw2.model.service.ManagementSystem;
import com.hw2.model.service.Prison;

public class Run {

	public static void main(String[] args) {
		ManagementSystem system1 = new Company(10);
		ManagementSystem system2 = new Prison(10);
		
		Person emp1 = new Employee("EMP001", "유재석", "기획팀");
		Person emp2 = new Employee("EMP002", "정형돈", "개발팀");
		
		system1.addPerson(emp1);
		system1.addPerson(emp2);
		
		system1.displayPerson();
		
		System.out.println("=================================================================");
		
		Person prs1 = new Prisoner("1205", "정준하", "밥도둑");
		Person prs2 = new Prisoner("0705", "박명수", "웃음연쇄살인");
		
		system2.addPerson(prs1);
		system2.addPerson(prs2);
		
		system2.displayPerson();
		
		System.out.println("=================================================================");
		
		system1.removePerson("EMP001");
		system2.removePerson("1205");
		
		System.out.println("=================================================================");
		
		system1.displayPerson();
		system2.displayPerson();
	}
}
