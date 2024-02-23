package com.hw5.model.dto;

public class wizard extends Hero{
	private String name = "마법사";
	
	public wizard() {}
	
	public wizard(int hp, int power, int it, int ag, int gold) {
		super(hp, power, it, ag, gold);
	}

	public String getName() {
		return name;
	}


	
}
