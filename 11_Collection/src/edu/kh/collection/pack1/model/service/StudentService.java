package edu.kh.collection.pack1.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import edu.kh.collection.pack1.model.vo.Student;

public class StudentService {

	// 필드
	private Scanner sc = new Scanner(System.in);
	
	// 학생 정보를 저장할 List 생성
	
	// java.util.List 인터페이스 : List에 반드시 필요한 필수기능을 모아둔 인터페이스
	// * 인터페이스 객체 생성 X, 부모 참조변수 O
	
	// java.util.ArrayList : 배열 형태 List (가장 태표적인 List 자식 클래스)
	
	// ArrayList() 기본생성자 : 기본 크기 10짜리 리스트생성
	//					-> 하지만 리스트는 크기가 늘었다 줄었다 하기때문에 큰의미 없음.
	
	// ArrayList(용량) : 용량만큼의 리스트 생성
	//				-> 너무 큰값을 작성하면 메모리를 많이 소모함.
	
	private List<Student> studentList = new ArrayList<Student>(); // 검색(조회)에 효율적
	//private List studentList = new LinkedList<Student>(); // 추가, 수정, 삭제에 효울적
	
	public StudentService() { // 기본생성자
		
		studentList.add( new Student("홍길동", 25, "서울시 중구", 'M', 90));
		studentList.add( new Student("고영희", 23, "경기도 안산시", 'F', 100));
		studentList.add( new Student("강아지", 30, "서울시 강남구", 'M', 80));
		studentList.add( new Student("오미나", 27, "충북 청주시", 'F', 90));
		studentList.add( new Student("박주희", 24, "서울시 서대문구", 'F', 70));		
	}
	

	
	
	
	
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
			System.out.println("7. 나이순으로 정렬"); // Comparable 사용
			System.out.println("8. 이름순으로 정렬"); // Comparator 사용
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 번호 선택 : ");
			
			try {
				
				menuNum = sc.nextInt();
				System.out.println();
				
				switch(menuNum) {
				case 1 : System.out.println( addStudent() ); break;
				case 2 : selectAll(); break;
				case 3 : System.out.println( updateStudent() ); break;
				case 4 : System.out.println( removeStudent() ); break;
				case 5 : searchName1(); break;
				case 6 : searchName2(); break;
				case 7 : sortByAge(); break;
				case 8 : sortByName(); break;
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
	
	/**
	 * 학생 전체 조회 메서드
	 * - List가 비어있는 경우 "학생 정보가 없습니다" 출력
	 * - 있는 경우 전체 학생 출력
	 */
	public void selectAll() {
		// - List에 저장된 데이터의 개수를 얻어오는 방법 : int List.size()
		// -> 배열명.length 대신 사용
		
		System.out.println("========학생 전체 조회=========");
		
		// studentList가 비어있는 경우 "학생 정보가 없습니다" 출력
		
		//if(studentList.size() == 0)
		if(studentList.isEmpty()) { // 컬렉션이 비어있다면 true 반환
			System.out.println("학생 정보가 없습니다");
			return; // 현재 메소드를 종료하고 호출한 곳으로 돌아감.
					// 단, 반환값은 없다(void)
		}
		
		
		
		// 일반 for문
		/*
		for(int i = 0; i < studentList.size(); i++) {
			System.out.println( studentList.get(i) );
		}*/
		
		//향상된 for문 (for each문)
		// -컬렉션, 배열의 모든 요소를 순차적으로 반복접근 할 수 있는 for문
		// (순차적 : 0번 인덱스부터 마지막 요소까지 인덱스를 1씩 증가)
		
		// 작성법
		// for( 컬렉션 또는 배열에서 꺼낸 한개의 요소를 저장할 변수 : 컬렉션명 또는 배열명 ) {}
		
		int index = 0;
		for( Student std : studentList ) {
			// std에는 for문 반복 시 마다 0,1,2....인덱스 요소들 한번씩 저장됨
			System.out.print( (index++) + "번 : ");
			System.out.println(std);
		}
		
		
		
		
	}
	
	
	/**
	 * 학생 정보 수정 메서드
	 * - 학생정보가 studentList에 있는지 검사, 없다면 "입력된 학생 정보가 없습니다" 문자열 반환
	 * - 입력된 숫자가 0보다 작은지 검사, 작다면 "음수는 입력할 수 없습니다" 문자열 반환
	 * - studentList 범위 내 인덱스번호인지 검사, 초과했다면 "범위를 넘어선 값을 입력할 수 없습니다" 문자열 반환
	 * - 수정이 완료되었다면, "000의 정보가 변경되었습니다" 문자열 반환
	 */
	public String updateStudent() throws InputMismatchException{
		
		// Student List.set(int index, Student e)
		// -> List의 index번째 요소를 전달받은 e로 변경
		// -> 반환값 Student == 변경 전 Student 객체개 담겨있다.
		
		System.out.println("=======학생 정보 수정=======");
		
		System.out.print("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		// 1) 학생정보가 studentList에 있는지 검사, 없다면 "입력된 학생 정보가 없습니다" 문자열 반환
		if( studentList.isEmpty() ) {
			return "입력된 학생 정보가 없습니다";
		
		// 2) 입력된 숫자가 0보다 작은지 검사, 작다면 "음수는 입력할 수 없습니다" 문자열 반환
		} else if( index < 0 ) {
			return "음수는 입력할 수 없습니다";
		
		// 3) studentList 범위 내 인덱스번호인지 검사, 초과했다면 "범위를 넘어선 값을 입력할 수 없습니다" 문자열 반환
		} else if ( index >= studentList.size() ) {
			return "범위를 넘어선 값을 입력할 수 없습니다";
			
			// 4) 만약 문자열을 입력한 경우 -> 예외처리 throws
		} else {
			// 수정 코드 작성
			
			System.out.println(index + "번째에 저장된 학생 정보");
			System.out.println( studentList.get(index) );
			
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
			
			// 입력받은 index번째에 새로운 학생 정보를 세팅 == 수정
			// index 번째에 있던 기존 학생 정보가 반환되고, 그 객체를 temp에 저장한다.
			Student temp = studentList.set(index, new Student(name, age, region, gender, score));
			
			return temp.getName() + "의 정보가 변경되었습니다";
			
			
		}
		
		

		
	}
	
	
	
	/** 학생 정보 제거 메서드
	 * @return String
	 */
	public String removeStudent() {
		
		// Student List.remove(int index)
		// 리스트에서 index번째 요소를 제거
		// 이 때, 제거된 요소가 반환된다.
		// * List는 중간에 비어있는 인덱스가 없게 하기 위해서
		// remove() 동작 시 뒤쪽 요소를 한 칸씩 당겨온다.
		
		System.out.println("=======학생 정보 제거=======");
		
		System.out.print("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		// 1) 학생정보가 studentList에 있는지 검사, 없다면 "입력된 학생 정보가 없습니다" 문자열 반환
		if( studentList.isEmpty() ) {
			return "입력된 학생 정보가 없습니다";
				
		// 2) 입력된 숫자가 0보다 작은지 검사, 작다면 "음수는 입력할 수 없습니다" 문자열 반환
		} else if( index < 0 ) {
			return "음수는 입력할 수 없습니다";
				
		// 3) studentList 범위 내 인덱스번호인지 검사, 초과했다면 "범위를 넘어선 값을 입력할 수 없습니다" 문자열 반환
		} else if ( index >= studentList.size() ) {
			return "범위를 넘어선 값을 입력할 수 없습니다";
					
		// 4) 만약 문자열을 입력한 경우 -> 예외처리 throws
		} else {
					
			// 학생 정보 제거
			
			System.out.print("정말 삭제 하시겠습니까? (Y/N) : ");
			char ch = sc.next().toUpperCase().charAt(0);
			//		String 대문자 -> 대문자 0번 인덱스 문자
			
			// String.toUpperCase() : 문자열을 대문자로 변경
			// String.toLowerCase() : 문자열을 소문자로 변경
			
			if(ch == 'Y') {
				Student temp = studentList.remove(index);
				return temp.getName() + "의 정보가 제거되었습니다";
				
			} else {
				return "취소";
			}
			
			
			
			
		}
	}
	
	/**
	 * 이름이 일치하는 학생을 찾아서 조회하는 메서드(완전 일치)
	 * 검색할 이름 입력받아 studentList에서 꺼내온 Student 객체에 Name값에 일치되는 문자열인지 검사
	 * - 일치하는 경우 Student 객체 출력
	 * - 검색 결과가 없습니다 출력
	 */
	public void searchName1() {
		System.out.println("=====학생 검색(이름 완전 일치)=====");
		
		System.out.print("검색할 이름 입력 : ");
		String input = sc.next();
		
		boolean flag = true;
		
		// 향상된 for문
		for(Student std : studentList) {
			
			if( input.equals( std.getName() )) { // 이름이 일치하는 경우
				System.out.println( std ); // std.toString();
				
				flag = false;
				
			}
		}
		
		if(flag) {
			System.out.println("검색 결과가 없습니다");
		}
		
	}
	
	
	
	/**
	 * 이름을 포함하는 학생을 찾아서 조회하는 메서드(포함)
	 * 검색할 이름 입력받아 studentList에서 꺼내온 Student 객체에 Name값에 포함되는 문자열인지 검사
	 * - 포함되는 경우 Student 객체 출력
	 * - 검색 결과가 없습니다 출력
	 */
	public void searchName2() {
		System.out.println("=====학생 검색(이름 포함)=====");
		
		System.out.print("검색할 이름 입력 : ");
		String input = sc.next();
		
		boolean flag = true;
		
		// 향상된 for문
		for(Student std : studentList) {
			
			if( std.getName().contains(input) ) { // 이름이 일치하는 경우
				System.out.println( std ); // std.toString();
				
				flag = false;
				
			}
		}
		
		if(flag) {
			System.out.println("검색 결과가 없습니다");
		}
		
	}
	
	
	public void sortByAge() {
		// 나이에 따라 오름차순 정렬
		Collections.sort(studentList);
		
		// 정렬된 결과 출력
		for(Student std : studentList) {
			System.out.println(std);
		}
	}
	
	public void sortByName() {
		
		// 이름에 따라 정렬하는 Comparator 객체 생성
		Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
		// Comparator 인터페이스의 static 메서드인 comparing()을 사용하여 Comparator를 생성
		// -> comparing()는 주어진 키(key)를 기반으로 객체를 비교함.
		// Student::getName : 메서드 레퍼런스(Method Reference)
		// -> Student 클래스의 getName() 메서드를 가리키는 것.
		// -> 이 메서드를 비교의 키로 사용하여 각 Student 객체를 비교하고 정렬함.
		// --> Comparator.comparing(Student:;getName)은 이름(name)을 기준으로
		//		학생(Student) 객체를 비교하는 Comparator 를 생성.
		
		
		
		
		// 이름에 따라 정렬
		Collections.sort(studentList, nameComparator);
		
		// 정렬된 결과 출력
		for(Student std : studentList) {
			System.out.println( std );
		}
		
		
	}
	
	
	
	
	
	
	
}
