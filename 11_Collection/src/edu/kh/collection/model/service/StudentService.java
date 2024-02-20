package edu.kh.collection.model.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import edu.kh.collection.model.vo.Student;

public class StudentService {

	// 필드
	private Scanner sc = new Scanner(System.in);
	
	// 학생 정보를 저장할 List 생성
	
	// java.util.List 인터페이스 : List에 반드시 필요한 필수기능을 모아둔 인터페이스
	// * 인터페이스 객체 생성 X, 부모 참조변수 O
	
	// java.util.ArrayList : 배열 형태 List (가장 태표적인 List 자식 클래스)
	
	// ArrayList() 기본생성자 : 기본 클기 10짜리 리스트생성
	//					-> 하지만 리스트는 크기가 늘었다 줄었다 하기때문에 큰의미 없음.
	
	// ArrayList(용량) : 용량만큼의 리스트 생성
	//				-> 너무 큰값을 작성하면 메모리를 많이 소모함.
	
	//private List<Student> studentList = new ArrayList<Student>(); // 검색(조회)에 효율적
	private List studentList = new LinkedList<Student>(); // 추가, 수정, 삭제에 효울적
	
	public void ex() {
		//List 테스트
		
		// List.add(Object e) : 리스트에 객체를 추가
		// * 매개변수 타입이 Object == 모든 객체 매개변수로 전달할 수 있음
		studentList.add(new Student()); // 0번 인덱스
		//studentList.add(sc); // 1번
		//studentList.add("문자열"); // 2번
		//studentList.add(new Object()); // 3번
		
		// 컬렉션 특징 : 여러타입의 데이터를 저장할 수 있다.
		
		// Object List.get(index i) : 리스트에서 i번째에 있는 객체를 반환
		// 반환형이 Object == 모든 객체를 반환할 수 있다.
		
		if( studentList.get(0) instanceof Student) {
			System.out.println( ((Student)studentList.get(0)).getName() );
		}
		
		
		System.out.println( studentList.get(1) );
		System.out.println( studentList.get(2) );
		System.out.println( studentList.get(3) );
		
		// 제네릭스 (Generics)
		// -> 컬렉션에 저장되는 객체 타입을 한가지로 제한 : <E>
	}
	
	
	// 메뉴 출력용 메서드
	
	/**
	 * alt + shift + j
	 * 메서드 설명용 주석
	 * @author rania2002@naver.com
	 */
	public void displayMenu() {
		
		int menuNum = 0; // 메뉴 선택용 변수
		
		do {
			
			System.out.println("\n============학생관리 프로그램===============\n");
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 정보 전체 조회");
			System.out.println("3. 학생 정보 수정");
			System.out.println("4. 학생 정보 제거");
			System.out.println("5. 이름으로 검색(일치)");
			System.out.println("6. 이름으로 검색(포함)");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 번호 선택 : ");
			
			try {
				
				menuNum = sc.nextInt();
				System.out.println();
				
				switch(menuNum) {
				case 1 : System.out.println( addStudent() ); break;
				case 2 : /*selectAll();*/ break;
				case 3 : /*updateStudent();*/ break;
				case 4 : /*removeStudent();*/ break;
				case 5 : /*searchName1();*/ break;
				case 6 : /*serchName2();*/ break;
				case 0 : System.out.println("프로그램 종료.."); break;
				default : System.out.println("메뉴에 작성된 번호만 입력하세요!");
				}
				
				
				
				
			} catch(InputMismatchException e) {
				System.out.println("\nerror : 입력형식이 유효하지 않습니다. 다시 시도해주세요.");
				sc.nextLine(); // 입력 버퍼에 남아있는 잘못된 코드 제거
				
				menuNum = -1; // 첫 반복시 잘못 입력하는 경우
				// menuNum이 0을 가지고 있어 종료되는데,
				// 이를 방지하기 위해 임의값 -1 대입
			}
			
			
			
			
		} while(menuNum != 0);
		
		
		
		
		
		
	}
	
	
	
	/**
	 * 1. 학생 정보 추가 메서드
	 * - 추가 성공 시 "성공" 실패 시 "실패" 문자열 반환
	 */
	public String addStudent() throws InputMismatchException{
		System.out.println("=========학생 정보 추가=========");
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine(); // 입력 버퍼 개행 문자 제거용
		
		System.out.print("사는 곳 : ");
		String region = sc.nextLine();
		
		System.out.print("성별(M/F) : ");
		char gender = sc.next().charAt(0); // 'M' or 'F'
		
		System.out.print("점수 : ");
		int score = sc.nextInt();
		
		// Student 객체 생성 후 List에 추가
		
		if(studentList.add(new Student(name, age, region, gender, score))) {
			// boolean java.util.List.add(Student e)
			// (반환형)				-> 제네릭 <Student> 때문에 List에 추가할수 있는 객체 타입이
			//						   Student로 제한됨
			
			return "성공";
		} else {
			return "실패";
		}
		
		
	}
	
	
	
	
	
	
}
