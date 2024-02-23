package com.hw5.model.dto;

public class worrior extends Hero{
	private String name = "전사";
	
	public worrior() {}
	
	public worrior(int hp, int power, int it, int ag, int gold) {
		super(hp, power, it, ag, gold);
	}

	public String getName() {
		return name;
	}

	
	

	

	
}
