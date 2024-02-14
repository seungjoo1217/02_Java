package com.hw3.controller;

import java.util.Scanner;

import com.hw3.model.vo.Product;

public class ProductController {

	private Product[] pro = new Product[10];
	
	public int count;
	
	Scanner sc = new Scanner(System.in);
	
	
	
	public void mainMenu() {
		
		int menuNum = -1;
		do {
			System.out.println("==== 제품 관리 메뉴 ====");
			System.out.println("1. 제품 정보 추가");
			System.out.println("2. 제품 전체 조회");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("번호 입력 : ");
			menuNum = sc.nextInt();
			sc.nextLine();
			
			switch(menuNum) {
			case 1 : productInput(); break;
			case 2 : productPrint(); break;
			case 0 : System.out.println("==== 프로그램 종료 ===="); break;
			default : System.out.println("잘못입력하셨습니다.");
			}
			
		} while(menuNum != 0);
	}
	
	
	
	public void productInput() {
		boolean flag = true;
		
		for(int i = 0; i < pro.length; i++) {
			
			if(pro[i] == null) {
				flag = false;
				
				System.out.print("제품 번호 입력 : ");
				int pld = sc.nextInt();
				
				System.out.print("제품명 입력 : ");
				String name = sc.next();
				
				System.out.print("제품 가격 입력 : ");
				int price = sc.nextInt();
				
				System.out.print("제품 세금 입력 : ");
				int tax = sc.nextInt();
				
				pro[i] = new Product(pld, name, price, tax);
				
				System.out.println("제품 입력이 완료되었습니다.");
				break;
			}
		}
		
		if(flag) {
			System.out.println("제품칸이 다 찼습니다.");
		}
	}
	
	public void productPrint() {
		boolean flag = true;
		
		for(int i = 0; i < pro.length; i ++) {
			
			if(!(pro[i] == null)) {
				flag = false;
				
				System.out.println("[제품" + i+1 + "의 정보]");
				System.out.println(pro[i].information());
				System.out.println();
			}
		}
		
		if(flag) {
			System.out.println("입력된 제품이 없습니다.");
		}
	}
}
