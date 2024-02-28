package com.kh.toypr.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.kh.toypr.model.service.MenuService;
import com.kh.toypr.model.service.MenuServiceImpl;

public class MenuView {

	//필드
	private BufferedReader br = null;
	private MenuService service = null;
	
	public MenuView() {
		try {
			service = new MenuServiceImpl();
			br = new BufferedReader(new InputStreamReader(System.in));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/** 맨 처음 시작화면
	 * 
	 */
	public void startView() {
		int num = 0;
		
		do {
			try {
				System.out.println("===================== Main View ======================");
				System.out.println("1. MANAGER");
				System.out.println("2. MEMBER");
				System.out.println("0. END");
				
				System.out.print("Select >>");
				num = Integer.parseInt(br.readLine());
				
				switch(num) {
				case 1 : managerView(); break;
				case 2 : loginMenu(); break;
				case 0 : System.exit(1); break;
				default : System.out.println("[잘못 입력하셨습니다]"); 
				}
				
			}catch(NumberFormatException e) {
				System.out.println("[숫자만 입력해주세요]");
				num = -1;
			}catch(IOException e) {
				System.out.println("[입/출력 예외 발생]");
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		} while(num != 0);
	}
	
	// -----------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------
	
	/**
	 * Manager Menu 프로그램 시작 화면
	 * @throws Exception 
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public void managerView() throws NumberFormatException, IOException, Exception {
		int managerNum = 1234;
		
		System.out.print("MANAGERNUM(1234) : ");
		int inputNum = Integer.parseInt(br.readLine());
		
		if(managerNum == inputNum) {
			int num = 0;
			
			do {
				num = managerMenu();
				
				switch(num) {
				case 1 : viewAll(); break;
				case 2 : addMember(); break;
				case 3 : removeMember(); break;
				case 9 : startView(); break;
				case 0 : System.exit(1); break;
				default : System.out.println("[잘못 입력하셨습니다]");
				}

				
			} while( num != 0 );
			
		} else {
			System.out.println("[관리자번호가 존재하지 않습니다.]");
			return;
		}
	}
	
	/**
	 * 관리자전용메뉴 표시
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public int managerMenu() throws NumberFormatException, IOException {
		System.out.println("===================== Zym MANAGER ======================");
		System.out.println("1. View All Member");
		System.out.println("2. Add Member");
		System.out.println("3. Remove Member");
		System.out.println("9. Previous");
		System.out.println("0. End");
		
		System.out.print("Select >>");
		int input = Integer.parseInt(br.readLine());
		
		System.out.println();
		return input;
	}
	
	// -----------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------
	

	
	/**
	 * 로그인, 메뉴선택 전용 표시
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	public void loginMenu() throws NumberFormatException, Exception {
		
		System.out.println("======================= Login =========================");
		System.out.print("ID >> ");
		String id = br.readLine();
		
		System.out.print("PASSWORD >> ");
		String pw = br.readLine();
		
		Map<String, Object> who = service.login(id, pw);
		
		if(who != null) {
			System.out.println("[로그인 성공]");
			memberMenu(who);
			

		} else {
			System.out.println("[로그인 실패]");
			startView();
		}
		

	}


	/**
	 * 회원전용메뉴 표시
	 * @throws Exception 
	 */
	public void memberMenu(Map<String, Object> member) throws Exception {
		int input = 0; 
	
		do {
			
			System.out.println("================ Zym Member [" + member.get("NAME") + "] =================");
			System.out.println("1. View Personal Information");
			System.out.println("2. Update Personal Information");
			System.out.println("3. View BMI");
			System.out.println("4. Attendance Zym");
			System.out.println("9. Previous");
			System.out.println("0. End");
			
			System.out.print("Select >>");
			input = Integer.parseInt(br.readLine());
			
			
			switch(input) {
			case 1 : viewPersonalInformation(member); break;
			case 2 : UpdatePersonalInformation(member); break;
			case 3 : viewBmi(member); break;
			case 4 : attendanceZym(member); break;
			case 9 : startView(); break;
			case 0 : System.exit(1); break;
			default : System.out.println("[잘못 입력하셨습니다]");
			}
			
		} while(input != 0);
	}
	
	
	// -----------------------------------------------------------------------------------------
	// -------------------------------------관리자메뉴---------------------------------------------
	
	
	
	
	
	
	/** 매니저 전용
	 * 회원 모두 보기
	 */
	public void viewAll() {
		System.out.println("\n================== View All Member ====================");
		
		System.out.println(service.viewAll());
	}
	
	/** 회원 추가하기
	 * @throws IOException
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public void addMember() throws IOException, NumberFormatException, Exception {
		System.out.println("\n================== Add Member ====================");
		
		System.out.print("MEMBERNUM : ");
		int num = Integer.parseInt(br.readLine());
		
		Map<String, Object> searchMem = service.searchMember(num);
		
		if(searchMem != null) {
			System.out.println("[이미 존재하는 회원번호입니다]");
			return;
		}
		
		System.out.print("ID : ");
		String id = br.readLine();
		
		System.out.print("PASSWORD : ");
		String pw = br.readLine();
		
		System.out.print("NAME : ");
		String name = br.readLine();
		
		System.out.print("AGE : ");
		int age = Integer.parseInt(br.readLine());
		
		System.out.print("GENDER : ");
		char gender = br.readLine().charAt(0);
		
		System.out.print("HEIGHT : ");
		int height = Integer.parseInt(br.readLine());
		
		System.out.print("WEIGHT : ");
		int weight = Integer.parseInt(br.readLine());
		
		int index = service.addMember(id, pw, num, name, age, gender, height, weight);
		
		if(index == -1) {
			System.out.println("[추가 실패]");
			return;
		}else {
			System.out.println("[추가 성공]");
		}
		
	}
	

	
	/** 회원 삭제
	 * @throws Exception 
	 */
	public void removeMember() throws Exception {
		System.out.println("\n=================== Remove Member =====================");
		
		System.out.print("MEMBERNUM : ");
		int num = Integer.parseInt(br.readLine());
		
		Map<String, Object> searchMem = service.searchMember(num);
		
		if(searchMem != null) {
			
			int index = service.removeMember(searchMem);
			
			if(index == -1) {
				System.out.println("[삭제 실패]");
				return;
			}else {
				System.out.println("[삭제 성공]");
				return;
			}
		}else {
			System.out.println("[일치하는 회원번호의 회원이 없습니다]");
			return;
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	// -----------------------------------------------------------------------------------------
	// --------------------------------------멤버메뉴----------------------------------------------
	
	/** 개인정보 보기
	 * @throws Exception 
	 * 
	 */
	public void viewPersonalInformation(Map<String, Object> member) throws Exception {
		System.out.println("\n============== View" + member.get("NAME") + " Information ================");
		
		System.out.println(member);
	}
	
	
	/** 개인정보 수정하기
	 * @throws Exception
	 */
	public void UpdatePersonalInformation(Map<String, Object> member) throws Exception{
		System.out.println("\n============== Update Personal Information ================");
		
		System.out.print("MEMBERNUM : ");
		int num = Integer.parseInt(br.readLine());
		
		System.out.print("NAME : ");
		String name = br.readLine();
		
		System.out.print("AGE : ");
		int age = Integer.parseInt(br.readLine());
		
		System.out.print("GENDER : ");
		char gender = br.readLine().charAt(0);
		
		System.out.print("HEIGHT : ");
		int height = Integer.parseInt(br.readLine());
		
		System.out.print("WEIGHT : ");
		int weight = Integer.parseInt(br.readLine());
		
		int index = service.updateMember(member, num, name, age, gender, height, weight);
		
		if(index == -1) {
			System.out.println("[수정 실패]");
		}else {
			System.out.println("[수정 성공]");
		}

	}
	
	/** 회원의 BMI 확인하기
	 * @param member
	 * @throws Exception
	 */
	public void viewBmi(Map<String, Object> member) throws Exception {
		System.out.println("\n================ View " + member.get("NAME") + "'s BMI" + " ==================");
		
		System.out.println(service.BMI(member));
	}
	
	
	/** 헬스장 출석하기/ 전체출석횟수 확인하기
	 * @param member
	 * @throws Exception
	 */
	public void attendanceZym(Map<String, Object> member) throws Exception {
		Set<Map<String, Object>> MenuSet = service.viewAllMember();
		
		System.out.println("\n================ " + member.get("NAME") + "'s Zym Attendance" + " ==================");
		System.out.println("\n================ Certification ==================");
		System.out.println("[인증을 위해 ID와 PASSWORD를 입력해주세요]");
		System.out.println();
		
		System.out.print("ID >> ");
		String id = br.readLine();
		
		System.out.print("PASSWORD >> ");
		String pw = br.readLine();
		
		
		int index = service.attendance(member, id, pw);
		
		if(index == -1) {
			System.out.println("[출석 인증 실패]");
		}else {
			System.out.println("[출석 인증 성공]");
			System.out.println("[전체 출석 수 : " + index + "]");
		}

		
	}
	
	
	
	
	
	

}