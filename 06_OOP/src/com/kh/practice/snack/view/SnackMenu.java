package com.kh.practice.snack.view;

import java.util.Scanner;

import com.kh.practice.snack.controller.SnackController;
import com.kh.practice.snack.model.vo.Snack;

public class SnackMenu {

	private Scanner sc = new Scanner(System.in);
	
	private SnackController scr = new SnackController();
	
	
	String kind = "";
	String name = "";
	String flavor = "";
	int num = 0;
	int price = 0;

	public void menu() {		
		System.out.println("스낵류를 입력하세요.");
		System.out.print("종류 : ");
		kind = sc.next();
		System.out.print("이름 : ");
		name = sc.next();
		System.out.print("맛 : ");
		flavor = sc.next();
		System.out.print("개수 : ");
		num = sc.nextInt();
		System.out.print("가격 : ");
		price = sc.nextInt();		
		
		System.out.println(scr.saveData(kind, name, flavor, num, price));
		
		System.out.print("저장한 정보를 확인하시겠습니까?(y/n) : ");
		String input = sc.next();
		
		if(input.equals("y")) {
			System.out.println(scr.confirmData());
		}
	}
	



	

	
	
}
