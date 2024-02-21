package com.hw4.model.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.hw4.model.dto.ToyDto;

public class ToyFactory {
	Scanner sc = new Scanner(System.in);
	Set<ToyDto> toys = new LinkedHashSet<ToyDto>();
	Map<Integer, String> material = new HashMap<Integer, String>();
	
	public ToyFactory() {
		
		material.put(1, "면직물");
		material.put(2, "플라스틱");
		material.put(3, "유리");
		material.put(4, "고무");
		
		Set<String> toy1Set = new HashSet<String>();
		toy1Set.add(material.get(1));
		toy1Set.add(material.get(4));
		ToyDto toy1 = new ToyDto("마미롱레그", 8, 36000, "분홍색", 19950805, toy1Set);
		
		Set<String> toy2Set = new HashSet<String>();
		toy2Set.add(material.get(1));
		toy2Set.add(material.get(2));
		ToyDto toy2 = new ToyDto("허기워기", 5, 12000, "파란색", 19940312, toy2Set);
		
		Set<String> toy3Set = new HashSet<String>();
		toy3Set.add(material.get(1));
		toy3Set.add(material.get(2));
		ToyDto toy3 = new ToyDto("키시미시", 5, 15000, "분홍색", 19940505, toy3Set);
		
		Set<String> toy4Set = new HashSet<String>();
		toy4Set.add(material.get(1));
		toy4Set.add(material.get(2));
		ToyDto toy4 = new ToyDto("캣냅", 8, 27000, "보라색", 19960128, toy4Set);
		
		Set<String> toy5Set = new HashSet<String>();
		toy5Set.add(material.get(1));
		toy5Set.add(material.get(2));
		toy5Set.add(material.get(4));
		ToyDto toy5 = new ToyDto("파피", 12, 57000, "빨간색", 19931225, toy5Set);
		
		
		toys.add(toy1);
		toys.add(toy2);
		toys.add(toy3);
		toys.add(toy4);
		toys.add(toy5);
	}
	
	public void displayMenu() {
		int menuNum = 0;
		do {
			System.out.println("<<플레이타임 공장>>");
			System.out.println("1. 전체 장난감 조회하기");
			System.out.println("2. 새로운 장난감 만들기");
			System.out.println("3. 장난감 삭제하기");
			System.out.println("4. 장난감 제조일 순으로 조회하기");
			System.out.println("5. 연령별 사용 가능한 장난감 리스트 조회하기");
			System.out.println("6. 재료 추가");
			System.out.println("7. 재료 제거");
			
			System.out.print("선택 : ");
			menuNum = sc.nextInt();
			
			switch(menuNum) {
			case 1 : showToy(); break;
			case 2 : createToy(); break;
			}
			
		} while(menuNum != 0);
	}
	
	
	public void showToy() {
		int index = 1;
		for(ToyDto toy : toys) {
			System.out.println((index++) + "." + toy.toString());
		}
	}
	
	
	public void createToy() {
		
		System.out.println("<새로운 장난감 추가>");
		System.out.print("장난감 이름 : ");
		String name = sc.next();
		
		System.out.print("사용 가능 연령 : ");
		int age = sc.nextInt();
		
		System.out.print("가격 : ");
		int price = sc.nextInt();
		
		System.out.print("색상 : ");
		String color = sc.next();
		
		System.out.print("제조일(YYYYMMDD 형식으로 입력) : ");
		int date = sc.nextInt();
		
		String input = "";
		Set<String> toySet = new HashSet<String>();
		do {
			System.out.print("재료를 입력하세요 (종료하려면 'q'를 입력하세요) : ");
			input = sc.next();
			
			toySet.add(input);
			
		} while ( !input.equals("q") );
		
		ToyDto toy = new ToyDto(name, age, price, color, date, toySet);
		toys.add(toy);
		System.out.println("새로운 장난감이 추가되었습니다.");
		
	}
}
