package com.hw4.model.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.hw4.model.dto.ToyDto;

public class ToyFactory {
	private Scanner sc = new Scanner(System.in);
	private Set<ToyDto> toys = new HashSet<ToyDto>(); // 중복된 Toy 객체가 없도록 저장할 컬렉션 중 Set
	private Map<Integer, String> materials = new HashMap<Integer, String>(); // 재료가 저장되어있는 map
	
	public ToyFactory() {
		
		materials.put(1, "면직물");
		materials.put(2, "플라스틱");
		materials.put(3, "유리");
		materials.put(4, "고무");
		

		ToyDto toy1 = new ToyDto("마미롱레그", 8, 36000, "분홍색", "19950805", addMaterials(1, 4));
		ToyDto toy2 = new ToyDto("허기워기", 5, 12000, "파란색", "19940312", addMaterials(1, 2));
		ToyDto toy3 = new ToyDto("키시미시", 5, 15000, "분홍색", "19940505", addMaterials(1, 2));
		ToyDto toy4 = new ToyDto("캣냅", 8, 27000, "보라색", "19960128", addMaterials(1, 2));
		ToyDto toy5 = new ToyDto("파피", 12, 57000, "빨간색", "19931225", addMaterials(1, 2, 4));
		
		
		toys.add(toy1);
		toys.add(toy2);
		toys.add(toy3);
		toys.add(toy4);
		toys.add(toy5);
	}
	
	// material에 전달받은 값들을 추가하고 Set으로 반환하는 메서드
	public Set<String> addMaterials(Integer...newMaterial) {
		
		Set<String> addedMaterial = new HashSet<String>();
		
		for(Integer materialKey : newMaterial) {
			
			// 맵에서 해당 번호(key)에 대응하는 재료를 가져와 추가
			String materialValue = materials.get(materialKey);
			
			if(materialValue != null) {
				addedMaterial.add(materialValue);
			}
		}
		
		return addedMaterial;
		
	}
	
	
	
	public void displayMenu() {
		int menuNum = 0;
		do {
			System.out.println("<<플레이타임 공장>>");
			System.out.println();
			
			System.out.println("1. 전체 장난감 조회하기");
			System.out.println("2. 새로운 장난감 만들기");
			System.out.println("3. 장난감 삭제하기");
			System.out.println("4. 장난감 제조일 순으로 조회하기");
			System.out.println("5. 연령별 사용 가능한 장난감 리스트 조회하기");
			System.out.println("6. 재료 추가");
			System.out.println("7. 재료 제거");
			
			System.out.print("선택 : ");
			
			try {
				menuNum = sc.nextInt();
				
				switch(menuNum) {
				case 1 : showToy(); break;
				case 2 : createToy(); break;
				case 3 : removeToy(); break;
				case 4 : displayToysByManufactureDate(); break;
				case 5 : displayToysByAge(); break;
				case 6 : addMaterial(); break;
				case 7 : removeMaterialByName(); break;
				case 0 : System.out.println("프로그램을 종료합니다"); break;
				default : System.out.println("잘못된 입력입니다. 다시 입력해주세요!");
				}
				
			} catch(Exception e) {
				System.out.println("알맞은 입력을 해라...(경고)..");
				
				sc.nextLine();
				
				menuNum = -1; // 첫 반복에서 예외 발생 시 종료되지 않도록 menuNum 값을 임의의 값으로 세팅
			}
			
		} while(menuNum != 0);
	}
	
	// 전체 장난감 조회하기
	public void showToy() {
		System.out.println("<전체 장난감 목록>");
		int index = 1;
		for(ToyDto toy : toys) {
			System.out.println((index++) + ". " + toy);
		}
	}
	
	// 새로운 장난감 만들기
	public void createToy() throws Exception {
		System.out.println("<새로운 장난감 추가>");
		
		System.out.print("장난감 이름 : ");
		String name = sc.next();
		
		// 기존에 있는 장난감인지 확인
		for(ToyDto existToy : toys) {
			
			if(existToy.getName().equals(name)) {
				System.out.println("이미 같은 이름을 가진 장난감이 존재합니다.");
				return;
			}
		}
		
		System.out.print("사용 가능 연령 : ");
		int age = sc.nextInt();
		
		System.out.print("가격 : ");
		int price = sc.nextInt();
		
		System.out.print("색상 : ");
		String color = sc.next();
		
		System.out.print("제조일 (YYYYMMDD 형식으로 입력) : ");
		String date = sc.next();
		
		Set<String> materialsSet = new HashSet<String>(); // 재료 저장할 컬렉션
		while(true) {
			System.out.print("재료를 입력하세요 (종료하려면 'q'를 입력하세요) : ");
			String input = sc.next();
			if( input.equals("q")){
				break;
			}
			
			materialsSet.add(input);
		}
		
		ToyDto newToy = new ToyDto(name, age, price, color, date, materialsSet);
		
		toys.add(newToy);

		System.out.println("새로운 장난감이 추가되었습니다.");
		
	}
	
	// 장난감 삭제하기
	public void removeToy() {
		System.out.print("삭제할 장난감의 이름을 입력하세요 : ");
		String input = sc.next();
		
		boolean flag = false;
		
		for(ToyDto toy : toys) {
			if(toy.getName().equals(input)) {
				toys.remove(toy);
				System.out.println("장난감이 삭제되었습니다.");
				flag = true;
				break;
			}
		}
		
		if(flag) {
			System.out.println("장난감이 삭제되었습니다.");
		} else {
			System.out.println("해당하는 이름의 장난감을 찾을 수 없습니다.");
		}
		
	}
	
	// 제조일순으로 장난감 정렬하기
	public void displayToysByManufactureDate() {
		
		System.out.println("<제조일 순으로 장난감을 정렬>");
		
		List<ToyDto> toyListSortedByDate = new ArrayList<ToyDto>(toys);
		
		toyListSortedByDate.sort(Comparator.comparing(ToyDto::getDate));
		
		int index = 1;
		for(ToyDto toy : toyListSortedByDate) {
			System.out.println((index++) + ". " + toy);
		}

		
	}
	
	// 연령별 장난감 정렬하여 출력하기 
	
	public void displayToysByAge() {
		System.out.println("<연령별로 사용 가능한 장난감>");
		
		Map<Integer, List<ToyDto>> toysByAge = new HashMap<Integer, List<ToyDto>>();
		// toysByAge 라는 이름의 새로운 맵을 생성
		// -> 연령을 key로 하고, 해당 연령을 가진 장난감 List를 value로 가짐
		//	{ K : V } -> { 5 : ["키시미시", "허기워기"] }
		
		for (ToyDto toy : toys) {
			
			int age = toy.getAge(); // 5
			
			toysByAge.putIfAbsent(age, new ArrayList<ToyDto>());
			// putIfAbsent() : Map 인터페이스에서 제공되는 메서드로,
			// 해당 키가 존재하지 않는 경우에만 전달받은 값을 추가함.
			// -> 맵에 해당 연령의 리스트가 없는 경우에만 새로운 리스트를 생성하여 추가
			
			toysByAge.get(age).add(toy);
			
		}
		
		for(Entry<Integer, List<ToyDto>> entry : toysByAge.entrySet()) {
			
			int age = entry.getKey();
			List<ToyDto> toyList = entry.getValue();
			
			System.out.println("[연령 : " + age + "세]");
			int index = 1;
			for(ToyDto toy : toyList) {
				System.out.println((index++) + ". " + toy);
			}
			
		}
		

		
	}
	
	
	// 재료 추가하기
	public void addMaterial() throws Exception{
		
		System.out.println("<재료 추가>");
		System.out.println("---현재 등록된 재료---");
		
		for(Entry<Integer, String> entry : materials.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		System.out.println("-----------------------------");
		
		System.out.println("재료 고유번호(Key) 입력 : ");
		int key = sc.nextInt();
		
		System.out.println("재료명 입력 : ");
		String material = sc.next();
		
		if(materials.containsKey(key)) {
			System.out.println("이미 해당 키에 재료가 등록되어 있습니다.");
			System.out.print("덮어쓰시겠습니까? (Y/N) : ");
			String input = sc.next();
			
			if(input.equalsIgnoreCase("Y")) {
				materials.put(key,  material);
				System.out.println("재료가 성공적으로 덮어쓰기 되었습니다!");
				
			} else {
				System.out.println("재료 추가가 취소되었습니다.");
			}
			
			
		} else {
			materials.put(key, material);
			System.out.println("새로운 재료가 성공적으로 등록되었습니다~!");
		}
		
		
		
	}
	
	
	
	// 재료명으로 재료 삭제하기
	public void removeMaterialByName() throws Exception{
		
		System.out.println("<재료 삭제>");
		System.out.println("---현재 등록된 재료---");
		
		for(Entry<Integer, String> entry : materials.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		System.out.println("-----------------------------");
		
		
		
		System.out.print("삭제할 재료명 입력 : ");
		String materialName = sc.next();
		
		boolean flag = false;
		
		
		for(Entry<Integer, String> entry : materials.entrySet()) {
			
			if(entry.getValue().equals(materialName)) {
				materials.remove(entry.getKey());
				System.out.println("재료 " + entry.getValue() + "가 성공적으로 제거되었습니다.");
				flag = true;
				break;
			}
			
		}
		
		if(!flag) {
			System.out.println("해당 이름의 재료가 존재하지 않습니다.");
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
