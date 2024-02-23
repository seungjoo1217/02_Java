package com.hw5.model.dto;

public class thief extends Hero{
	private String name = "도적";
	
	public thief() {}
	
	public thief(int hp, int power, int it, int ag, int gold) {
		super(hp, power, it, ag, gold);
	}

	public String getName() {
		return name;
	}

	
}
