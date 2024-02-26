package com.hw3.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.hw3.model.dto.Book;

public class BookService {
	Scanner sc = new Scanner(System.in);
	List<Book> books = new ArrayList<Book>();
	List<Book> bookmarks = new ArrayList<Book>();
	
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
			
			try {
				switch(menuNum) {
				case 1 : addBook(); break;
				case 2 : searchBook(); break;
				case 3 : updateBook(); break;
				case 4 : removeBook(); break;
				case 5 : addBookmark(); break;
				case 6 : removeBookmark(); break;
				case 7 : searchBookmark(); break;
				case 8 : recommend(); break;
				case 0 : System.out.println("프로그램을 종료합니다."); break;
				default : System.out.println("잘못 입력하셨습니다.");
				}
				
			}catch(Exception e) {
				System.out.println("잘못 입력하셨습니다.");
				e.printStackTrace();
				sc.nextLine();
			}
			
		} while(menuNum != 0);
	}
	
	public void addBook() throws Exception{
		System.out.println("=======도서 등록=======");
		System.out.print("도서 번호를 입력하세요 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		for(Book book : books) {
			if(book.getBookNumber() == num) {
				System.out.println("이미 존재하는 도서입니다.");
				return;
			}else {
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
				System.out.println("등록 완료");
				return;
			}
		}
	}
	
	public void searchBook() throws Exception{
		System.out.println("=======도서 조회=======");
		for(Book book : books) {
			System.out.println(book.toString());
		}
	}
	
	public void updateBook() throws Exception{
		System.out.println("=======도서 수정=======");
		System.out.print("수정할 도서 번호를 입력하세요 : ");
		int input = sc.nextInt();
		boolean flag = true;
		
		for(Book book : books) {
			if(book.getBookNumber() == input) {
				flag = false;
				int menuNum = 0;
				do {
					System.out.println("1. 도서명");
					System.out.println("2. 도서 저자");
					System.out.println("3. 도서 가격");
					System.out.println("4. 도서 출판사");
					System.out.println("0. 수정 종료");
					
					System.out.print("어떤 정보를 수정하시겠습니까? : ");
					menuNum = sc.nextInt();
					
					if(menuNum == 1) {
						System.out.println("=======도서 수정=======");
						System.out.print("수정할 도서명을 입력하세요 : ");
						String title = sc.next();
						
						book.setTitle(title);
						System.out.println("수정 완료");
					} else if(menuNum == 2) {
						System.out.println("=======도서 저자 수정=======");
						System.out.print("수정할 저자를 입력하세요 : ");
						String author = sc.next();
						
						book.setAuthor(author);
						System.out.println("수정 완료");
					} else if(menuNum ==  3) {
						System.out.println("=======도서 가격 수정=======");
						System.out.print("수정할 가격을 입력하세요 : ");
						int price = sc.nextInt();
						
						book.setPrice(price);
						System.out.println("수정 완료");
					} else if(menuNum == 4) {
						System.out.println("=======도서 출판사 수정=======");
						System.out.print("수정할 출판사를 입력하세요 : ");
						String publisher = sc.next();
						
						book.setPublisher(publisher);
						System.out.println("수정 완료");
					} else if(menuNum == 0) {
						System.out.println("수정이 종료되었습니다.");
					} else {
						System.out.println("잘못 입력하셨습니다.");
						updateBook();
					}
				} while (menuNum != 0);
				
			}
			
		}
		if(flag) {
			System.out.println("수정할 도서가 존재하지 않습니다.");
			return;
		}
		
	}
	
	public void removeBook() throws Exception{
		System.out.println("=======도서 삭제=======");
		System.out.print("삭제할 도서의 번호를 입력하세요 : ");
		int input = sc.nextInt();
		boolean flag = true;
		
		for(Book book : books) {
			if(book.getBookNumber() == input) {
				flag = false;
				books.remove(book);
				System.out.println("삭제가 완료되었습니다.");
				return;
			}
		}
		
		if(flag) {
			System.out.println("도서번호가 존재하지 않습니다.");
			return;
		}
	}
	
	public void addBookmark() throws Exception{
		System.out.println("=======즐겨찾기 추가=======");
		System.out.print("즐겨찾기에 추가할 도서번호를 입력하세요 : ");
		int input = sc.nextInt();
		boolean flag = true;
		
		for(Book book : books) {
			if(book.getBookNumber() == input) {
				bookmarks.add(book);
				System.out.println("즐겨찾기 추가 완료");
				return;
			}
		}
		
		if(flag) {
			System.out.println("도서번호가 존재하지 않습니다.");
			return;
		}
	}
	
	public void removeBookmark() throws Exception{
		System.out.println("=======즐겨찾기 삭제=======");
		System.out.print("즐겨찾기에서 삭제할 도서번호를 입력하세요 : ");
		int input = sc.nextInt();
		boolean flag = true;
		
		for(Book book : bookmarks) {
			if(book.getBookNumber() == input) {
				bookmarks.remove(book);
				System.out.println("즐겨찾기 삭제 완료");
				return;
			}
		}
		
		if(flag) {
			System.out.println("도서번호가 존재하지 않습니다.");
			return;
		}
	}
	
	public void searchBookmark() throws Exception{
		System.out.println("=======즐겨찾기 조회=======");
		
		if(!bookmarks.isEmpty()) {
			for(Book book : bookmarks) {
				System.out.println(book);
			}
		}else {
			System.out.println("즐겨찾기 목록이 비어있습니다.");
			return;
		}
	}
	
	public void recommend() throws Exception{
		System.out.println("=======추천도서 뽑기=======");
		Random random = new Random();
		
		System.out.println("오늘의 추천 도서 : " +
						books.get(random.nextInt(books.size())));
	}
	

}
