package edu.kh.objarray.practice.run;

import edu.kh.objarray.practice.model.service.EmployeeService;

public class Run {

	public static void main(String[] args) {
		EmployeeService service = new EmployeeService();
		service.displayMenu();
	}
}
