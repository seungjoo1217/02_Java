package edu.kh.objarray.practice.model.vo;

public class Employee {

	private int employeeNo;
	private String employeeName;
	private String dept;
	private String job;
	private int salary;
	
	public Employee() {}
	
	public Employee(int employeeNo, String employeeName,
					String dept, String job, int salary) {
		
		this.employeeNo = employeeNo;
		this.employeeName = employeeName;
		this.dept = dept;
		this.job = job;
		this.salary = salary;
	}
	
	public String information() {
		return "사번 : " + employeeNo +
				", 이름 : " + employeeName +
				", 부서 : " + dept +
				", 직급 : " + job +
				", 급여 : " + salary + "\n";
	}

	
	
	
	
	public int getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
