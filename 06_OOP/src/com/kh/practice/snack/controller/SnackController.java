package com.kh.practice.snack.controller;

import com.kh.practice.snack.model.vo.Snack;

public class SnackController {
	private Snack s = new Snack();
	
	
	
	
	
	
	
	public SnackController() {}
	
	public String saveData(String kind, String name, String flavor, int numOf, int price) {
		
		return "저장 완료되었습니다.";
	}
	
	public String confirmData() {
		return s.getKind() + "(" + s.getName() + "-" + s.getFlavor() + ")" +
				s.getNumOf() + "개 " + s.getPrice() + "원";
	}

	
	
	
	
	
	
	public Snack getS() {
		return s;
	}

	public void setS(Snack s) {
		this.s = s;
	}
	
	
	
}
