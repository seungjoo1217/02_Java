package com.kh.toypr.model.dto;

import java.io.Serializable;
import java.util.Objects;

public class Member implements Serializable{
	private String id;
	private String pw;
	
	private int memberNum;
	private String name;
	private int age;
	private char gender;
	private int height;
	private int weight;
	private int attendance;
	
	public Member() {}

	public Member(String id, String pw, int memberNum, String name, int age, char gender, int height, int weight,int attendance) {
		super();
		this.id = id;
		this.pw = pw;
		this.memberNum = memberNum;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.attendance = attendance;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPw() {
		return pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getMemberNum() {
		return memberNum;
	}
	
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}


	public int getAttendance() {
		return attendance;
	}

	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}

	@Override
	public String toString() {
		return "MEMBERNUM : " + memberNum +
				"AGE : " + age + 
				"GENDER : " + gender +
				"HEIGHT : " + height + 
				"WEIGHT : " + weight +
				"ATTENDANCE : " + attendance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, attendance, gender, height, id, memberNum, name, pw, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return age == other.age && attendance == other.attendance && gender == other.gender && height == other.height
				&& Objects.equals(id, other.id) && memberNum == other.memberNum && Objects.equals(name, other.name)
				&& Objects.equals(pw, other.pw) && weight == other.weight;
	}

	

	

	

	
	
	
	
}
