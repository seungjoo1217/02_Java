package com.hw1.model.dto;

public class Textbook extends Book{

	private String subject;
	
	public Textbook() {}
	
	public Textbook(String title, String author, String subject) {
		super(title, author);
		this.subject = subject;
	}

	@Override
	public void displayInfo() {
		System.out.printf("[%s] 제목 : %s / 저자 : %s / 과목 : %s\n", "전문 서적", super.getTitle(), super.getAuthor(), subject);
		
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
