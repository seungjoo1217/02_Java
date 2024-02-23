package com.hw5.model.service;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.hw5.model.dto.Hero;
import com.hw5.model.dto.thief;
import com.hw5.model.dto.wizard;
import com.hw5.model.dto.worrior;

public class RPGService {
	Scanner sc = new Scanner(System.in);
	String id = "";
	String pw = "";
	Map<String, Object> Hero = new HashMap<String, Object>();
	

	public void main() {
		int menuNum = 0;
		System.out.println("===============RPG===============");
		System.out.println("1.새로시작 | 2.불러오기 | 3.종료");
		System.out.println("=================================");
		
		System.out.print("선택>>");
		menuNum = sc.nextInt();
		
		switch(menuNum) {
		case 1 : startGame(); break;
		case 2 : break;
		case 3 : System.out.println("게임이 종료되었습니다."); break;
		default : System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	
	public void startGame() {
		sc.nextLine();
		System.out.println("=====first Page=====");
		System.out.println("1.영웅선택 | 2.종료");
		System.out.println("====================");
		
		System.out.print("선택>>");
		int input = sc.nextInt();
		
		if(input == 1) {
			selectHero();
		} else if(input == 2) {
			System.out.println("게임이 종료되었습니다.");
		} else {
			System.out.println("잘못 입력하셨습니다.");
			startGame();
		}


		
	}
	
	
	public void selectHero() {
		System.out.println("===========Hero==========");
		System.out.println("1.전사 | 2.법사 | 3.도적");
		System.out.println("=========================");
		
		System.out.print("선택>>");
		int input = sc.nextInt();
		
		System.out.println("영웅이 선택되었습니다.");
		
		Hero hero = null;
		String job = "";
		if(input == 1) {
			job = "전사";
			hero = new worrior();
		}else if(input == 2) {
			job = "마법사";
			hero = new wizard();
		}else if(input == 3) {
			job = "도적";
			hero = new thief();
		} else {
			System.out.println("잘못 입력하셨습니다.");
			selectHero();
		}
		
		Hero.put("직업", job);
		Hero.put("체력", hero.getHp());
		Hero.put("파워", hero.getPower());
		Hero.put("지능", hero.getIt());
		Hero.put("민첩", hero.getAg());
		Hero.put("자산", hero.getGold());
		
		
		
		
		System.out.print("ID입력>>");
		id = sc.next();
		
		System.out.print("비번입력>>");
		pw = sc.next();
		
		System.out.println("캐릭터가 정상적으로 만들어졌습니다.");
		showTown();
	}
	
	
	public void showTown() {
		int input = 0;
		
		do {
			System.out.println("=======================Town=======================");
			System.out.println("1.영웅정보 | 2.던전탐험 | 3.상점 | 4.저장 | 5.종료");
			System.out.println("==================================================");
			
			System.out.print("선택>>");
			input = sc.nextInt();
			
			switch(input) {
			case 1 : showHero(); break;
			case 2 : travel(); break;
			}
			
		} while(input != 5);
		
	}
	
	public void showHero() {
		System.out.println("======" + id + "======");
		
		for(Entry<String, Object> entry : Hero.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
	
	public void travel() {
		System.out.println("======================던전=====================");
		System.out.println("1.동굴 | 2.심해 | 3.정글 | 4.마을로가기 | 5.종료");
		System.out.println("===============================================");
		
		System.out.print("선택>>");
		int input = sc.nextInt();
		
		switch(input) {
		case 1 : cave(); break;
		}
	}
	
	public void cave() {
		System.out.println("==========================================");
		System.out.println("==========================================");
		System.out.println("==========================================");
		System.out.println("====================동굴==================");
		System.out.println("==========================================");
		System.out.println("==========================================");
		System.out.println("==========================================");
		System.out.println();
		
		return;
	}
	
	
	
	
	
	
	
	
}
