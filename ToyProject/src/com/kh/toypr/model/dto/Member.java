package com.kh.toypr.model.dto;

import java.io.Serializable;
import java.util.Objects;

public class Member implements Serializable{
	private String name;
	private int age;
	private char gender;
	private int height;
	private int weight;
	
	public Member() {}

	public Member(String name, int age, char gender, int height, int weight) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
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

	@Override
	public String toString() {
		return "NAME : " + name + 
				"AGE : " + age + 
				"GENDER : " + gender +
				"HEIGHT : " + height + 
				"WEIGHT : " + weight;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, gender, height, name, weight);
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
		return age == other.age && gender == other.gender && height == other.height && Objects.equals(name, other.name)
				&& weight == other.weight;
	}
	
	
	
}
