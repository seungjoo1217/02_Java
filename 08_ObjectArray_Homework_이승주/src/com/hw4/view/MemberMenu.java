package com.hw4.view;

import java.util.Arrays;
import java.util.Scanner;

import com.hw4.controller.MemberController;
import com.hw4.model.vo.Member;

public class MemberMenu {
	
	// MemberController 클래스 접근을 위해 필드로 선언
	private MemberController mc = new MemberController();
	Scanner sc = new Scanner(System.in);
	
	
	public void mainMenu() {

		// 메뉴 출력
		int menuNum = -1;
		do {
			System.out.println("===== 회원 관리 메뉴 =====");
			System.out.println("1. 신규 회원 등록");
			System.out.println("2. 회원 정보 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 정보 삭제");
			System.out.println("5. 회원 정보 출력");
			System.out.println("6. 회원 정보 정렬");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 선택 : ");
			menuNum = sc.nextInt();
			
			switch(menuNum) {
			case 1 : insertMember(); break;
			case 2 : searchMember(); break;
			case 3 : updateMember(); break;
			case 4 : deleteMember(); break;
			case 5 : printAllMember(); break;
			case 6 : sortMember(); break;
			case 0 : System.out.println("==== 프로그램 종료 ===="); break;
			default : System.out.println("잘못 입력하셨습니다.");
			}
			
		} while(menuNum != 0);
	}
	
	
	public void insertMember() {
		// 1. 현재 회원 수(memberCount)가 최대 회원 수(SIZE)를 넘어설 경우 return 처리
		
		
		// 2. 아이디를 입력 받아 MemberControllerdml checkId() 메소드로 전달 >> 결과 값
		System.out.print("아이디를 입력해 주세요 : ");
		String id = sc.next();
		if(mc.checkld(id) != null) {
			System.out.println("동일한 아이디가 존재합니다. 회원등록 실패");
		}else {
			System.out.print("비밀번호를 입력해 주세요 : ");
			String pw = sc.next();
			
			System.out.print("비밀번호를 다시 입력해 주세요 : ");
			String pw2 = sc.next();
			
			System.out.print("이름을 입력해 주세요 : ");
			String name = sc.next();
			
			System.out.print("나이를 입력해 주세요 : ");
			int age = sc.nextInt();
			
			System.out.print("성별을 입력해 주세요(M/F) : ");
			char gender = sc.next().charAt(0);
			
			System.out.print("이메일을 입력해 주세요 : ");
			String email = sc.next();
			
			if(pw.equals(pw2)) {
				mc.insertMember(id, pw, name, age, gender, email);
				System.out.println("성공적으로 회원 등록이 되었습니다.");
			} else {
				System.out.println("회원가입 실패(비밀번호 불일치)");
			}
			
			
		}

	}
	
	
	public void searchMember() {
		
		int menu = -1;
		String search = "";
		// 메뉴 출력
		do {
			System.out.println("===== 회원 정보 검색 =====");
			System.out.println("1. 아이디로 검색하기");
			System.out.println("2. 이름으로 검색하기");
			System.out.println("3. 이메일로 검색하기");
			System.out.println("9. 이전 메뉴로");
			
			
			System.out.print("메뉴 선택 : ");
			menu = sc.nextInt();
			if(menu == 9) {
				break;
			}
			
			System.out.print("검색 내용 : ");
			search = sc.next();
			
			if (menu == 1 || menu == 2 || menu == 3){
				mc.searchMember(menu, search);
				if(mc.searchMember(menu, search) == null) {
					System.out.println("검색된 결과가 없습니다.");
				}else {
					System.out.println(mc.searchMember(menu, search).information());
				}
			}else {
				System.out.println("잘못 입력하셨습니다.");
			}
			
		} while(menu != 9);
		
		mainMenu();
		// 1. MemberController의 searchMember() 메소드로 menu와 search 문자열 전달 >> 결과 값
		// 1_1. 결과 값이 null인 경우 즉, 검색 결과가 없는 경우 >> "검색된 결과가 없습니다." 출력
		// 1_2. 결과 값이 null이 아닌 경우 즉, 검색 결과가 존재하는 경우 >> 회원 정보 출력
	}
	
	public void updateMember() {
		
		//메뉴 출력
		int menu = -1;
		String search = "";
		// 메뉴 출력
		do {
			System.out.println("===== 회원 정보 수정 =====");
			System.out.println("1. 비밀번호 수정");
			System.out.println("2. 이름 수정");
			System.out.println("3. 이메일 수정");
			System.out.println("9. 이전 메뉴로");
			
			System.out.print("메뉴 선택 : ");
			menu = sc.nextInt();
			if(menu == 9) {
				break;
			}
			
			System.out.print("변경할 회원 아이디 : ");
			search = sc.next();
			

			Member m = null;
			for(int i = 0; i < mc.getMemberCount(); i++) {
				if(mc.getMem()[i].getUserId().equals(search)) {
					m = mc.getMem()[i];
				}
			}
			

			
			if (menu == 1 || menu == 2 || menu == 3){
				if(m == null) {
					System.out.println("변경할 회원이 존재하지 않습니다");
				} else {
					System.out.print("변경내용을 입력하세요 : ");
					String update = sc.next();
					
					mc.updateMember(m, menu, update);
					System.out.println("회원의 정보가 변경되었습니다.");
				}
			}else {
				System.out.println("잘못 입력하셨습니다.");
			}
			
		} while(menu != 9);
		
		mainMenu();
		//1. MemberContriller의 checkId로 userId 전달 >> 결과 값 (m: Member)
		// 1_2. 결과 값이 null인 경우 >> "변경할 회원이 존재하지 않습니다" 출력
		// 1_2. 결과 값이 null이 아닌 경우 기존 정보 출력 후
				//	변경내용(update) 입력 받고
		//	MemberController의 updateMember()에 m, menu, update 전달
		//	"회원의 정보가 변경되었습니다." 출력
	}
	
	public void deleteMember() {
		
		System.out.print("삭제할 회원 아이디 : ");
		String userId = sc.next();
		
		Member m = null;
		for(int i = 0; i < mc.getMemberCount(); i++) {
			if(mc.getMem()[i].getUserId().equals(userId)) {
				m = mc.getMem()[i];
			}
		}
		
		if(m == null) {
			System.out.println("삭제할 회원이 존재하지 않습니다.");
		} else {
			System.out.print("정말 삭제하시겠습니까? (y/n) : ");
			char confirm = sc.next().charAt(0);
			
			if(confirm == 'y' || confirm == 'Y') {
				mc.deleteMember(userId);
				System.out.println("회원의 정보가 삭제되었습니다.");
			} else {
				mainMenu();
			}
		}
		// 1. MemberController의 checkId()에 userId전달 >> 결과 값 (m : Member)
		// 1_1. 결과 값이 null인 경우 "삭제할 회원이 존재하지 않습니다." 출력
		// 1_2. 결과 값이 null이 아닌 경우 기존 정보 출력
		//	"정말 삭제하시겠습니까? (y/n) : " >> 키보드로 입력 받기
		//	대소문자 구분 없이 'Y'인 경우 MemberController의 deleteMember()에 userId 전달
		//	"회원의 정보가 삭제되었습니다." 출력
	}
	
	public void printAllMember() {
		// MemberController의 getMem() 메소드 호출 >> 결과 값 (mem : Member[])
		// 반복문을 통해 결과 값 안의 존재하는 회원들 정보 출력
		for(int i = 0; i < mc.getMemberCount(); i ++) {
			System.out.println(mc.getMem()[i].information());
		}
	}
	
	public void sortMember() {
		
		Member[] sortMem = null;
		
		// 메뉴 출력
		int menu = -1;
		String search = "";
		// 메뉴 출력
		// 반복문을 통해 sortMem 객체 배열 출력
		do {
			System.out.println("===== 회원 정보 정렬 =====");
			System.out.println("1. 아이디 오름차순 정렬");
			System.out.println("2. 아이디 내림차순 정렬");
			System.out.println("3. 나이 오름차순 정렬");
			System.out.println("4. 나이 내림차순 정렬");
			System.out.println("5. 성별 내림차순 정렬(남여순)");
			System.out.println("9. 이전 메뉴로");
			
			
			System.out.print("메뉴 선택 : ");
			menu = sc.nextInt();
			if(menu == 9) {
				break;
			}
			
			switch(menu) {
			case 1 : 
				for(int i = 0; i < mc.sortIdAsc().length; i++) {
					System.out.println(mc.sortIdAsc()[i].information());
				} break;
			case 2 : 
				for(int i = 0; i < mc.sortIdDesc().length; i++) {
					System.out.println(mc.sortIdDesc()[i].information());
				} break;
			case 3 : 
				for(int i = 0; i < mc.sortAgeAsc().length; i++) {
					System.out.println(mc.sortAgeAsc()[i].information());
				} break;
			case 4 : 
				for(int i = 0; i < mc.sortAgeDesc().length; i++) {
					System.out.println(mc.sortAgeDesc()[i].information());
				} break;
			case 5 : 
				for(int i = 0; i < mc.sortGenderDesc().length; i++) {
					System.out.println(mc.sortGenderDesc()[i].information());
				} break;
			}
			
		} while(menu != 9);
		mainMenu();
	}
	

	
	
	
}
