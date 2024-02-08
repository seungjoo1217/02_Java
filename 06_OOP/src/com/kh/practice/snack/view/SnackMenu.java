package com.kh.practice.snack.view;

import java.util.Scanner;

import com.kh.practice.snack.controller.SnackController;

public class SnackMenu {

	private Scanner sc = new Scanner(System.in);
	
	private SnackController scr = new SnackController();
	
	
	public void menu() {
		System.out.println("스낵류를 입력하세요.");
		System.out.print("종류 : ");
		String kind = sc.next();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("맛 : ");
		String flavor = sc.next();
		System.out.print("개수 : ");
		int num = sc.nextInt();
		System.out.print("가격 : ");
		int price = sc.nextInt();
	}


	
	
	
	
	public Scanner getSc() {
		return sc;
	}


	public void setSc(Scanner sc) {
		this.sc = sc;
	}


	public SnackController getScr() {
		return scr;
	}


	public void setScr(SnackController scr) {
		this.scr = scr;
	}
	

	
	
}