package com.hw3.model.service;

import java.awt.DisplayMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hw3.model.dto.Book;

public class BookService {
	Scanner sc = new Scanner(System.in);
	List<Book> books = new ArrayList<Book>();
	
	public BookService() {
		books.add(new Book(1111, "세이노의 가르침", "세이노", 6480, "데이원"));
		books.add(new Book(2222, "문과남자의 과학공부", "유시민", 6480, "돌베개"));
		books.add(new Book(3333, "역행자", "자청", 17550, "웅진지식하우스"));
		books.add(new Book(4444, "꿀벌의 예언", "베르나르 베르베르", 15120, "열린책들"));
		books.add(new Book(5555, "도둑맞은 집중력", "요한 하리", 16920, "어크로스"));
	}
	
	
	public void displayMenu() {
		
		
		int menuNum = 0;
		do {
			
			System.out.println("===도서 목록 프로그램===");
			System.out.println("1. 도서 등록");
			System.out.println("2. 도서 조회");
			System.out.println("3. 도서 수정");
			System.out.println("4. 도서 삭제");
			System.out.println("5. 즐겨찾기 추가");
			System.out.println("6. 즐겨찾기 삭제");
			System.out.println("7. 즐겨찾기 조회");
			System.out.println("8. 추천도서 뽑기");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴를 입력하세요 : ");
			menuNum = sc.nextInt();
			
			switch(menuNum) {
			case 1 : addBook(); break;
			case 2 : searchBook(); break;
			case 3 : updateBook(); break;
			case 4 : /*removeBook();*/ break;
			case 5 : /*addBookmark();*/ break;
			case 6 : /*removeBookmark();*/ break;
			case 7 : /*searchBookmark();*/ break;
			case 8 : /*recommend();*/ break;
			case 0 : System.out.println("프로그램을 종료합니다."); break;
			default : System.out.println("잘못 입력하셨습니다.");
			}
		} while(menuNum != 0);
	}
	
	public void addBook() {
		
		try {
			System.out.print("도서 번호를 입력하세요 : ");
			int num = sc.nextInt();
			sc.nextLine();
			
			System.out.print("도서 제목을 입력하세요 : ");
			String title = sc.nextLine();
			
			System.out.print("저자를 입력하세요 : ");
			String author = sc.nextLine();
			
			System.out.print("가격을 입력하세요 : ");
			int price = sc.nextInt();
			sc.nextLine();
			
			System.out.print("출판사를 입력하세요 : ");
			String publisher = sc.nextLine();
			
			books.add(new Book(num, title, author, price, publisher));
			System.out.println("도서 등록이 완료되었습니다.");
			
		} catch(Exception e) {
			System.out.println("잘못 입력하셨습니다.(등록 실패)");
		}
	}
	
	public void searchBook() {
		for(Book book : books) {
			System.out.println(book.toString());
		}
	}
	
	public void updateBook() {
		System.out.print("수정할 도서 번호를 입력하세요 : ");
		int input = sc.nextInt();
		
		int index = 0;
		for(int i = 0; i < books.size(); i++) {
			
		}
		
		int menuNum = 0;
		do {
			System.out.println("1. 도서명");
			System.out.println("2. 도서 저자");
			System.out.println("3. 도서 가격");
			System.out.println("4. 도서 출판사");
			System.out.println("0. 수정 종료");
			
			System.out.print("어떤 정보를 수정하시겠습니까?");
			menuNum = sc.nextInt();
			

		} while (menuNum != 0);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
