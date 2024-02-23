package com.hw5.model.dto;

public class Hero {
	private int hp;
	private int power = 100;
	private int it = 0;
	private int ag = 10;
	private int gold = 1000;
	
	
	public Hero() {}



	public Hero(int hp, int power, int it, int ag, int gold) {
		super();
		this.hp = hp;
		this.power = power;
		this.it = it;
		this.ag = ag;
		this.gold = gold;
	}



	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
	}


	public int getPower() {
		return power;
	}


	public void setPower(int power) {
		this.power = power;
	}


	public int getIt() {
		return it;
	}


	public void setIt(int it) {
		this.it = it;
	}


	public int getAg() {
		return ag;
	}


	public void setAg(int ag) {
		this.ag = ag;
	}


	public int getGold() {
		return gold;
	}


	public void setGold(int gold) {
		this.gold = gold;
	}
	
	
	
	
	
}
