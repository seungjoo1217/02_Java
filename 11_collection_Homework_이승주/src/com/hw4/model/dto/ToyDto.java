package com.hw4.model.dto;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class ToyDto {

	private String name;
	private int age;
	private int price;
	private String color;
	private int date;
	private Set<String> material;
	
	public ToyDto() {}



	public ToyDto(String name, int age, int price, String color, int date, Set<String> material) {
		super();
		this.name = name;
		this.age = age;
		this.price = price;
		this.color = color;
		this.date = date;
		this.material = material;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}
	
	public Set<String> getMaterial() {
		return material;
	}
	
	
	public void setMaterial(Set<String> material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "이름:" + name + "/가격:" + price + "/색상:" +
				color + "/사용가능연령:" + age + "/제조년월일:" +
				date + "/재료:" + material;
	}
	
	
}
