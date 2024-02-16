package com.hw1.model.dto;

public class Novel extends Book{
	private String genre;

	public Novel() {}
	
	public Novel(String title, String author, String genre) {
		super(title, author);
		this.genre = genre;
	}

	@Override
	public void displayInfo() {
		System.out.printf("[%s] 제목 : %s / 저자 : %s / 장르 : %s\n", "소설", super.getTitle(), super.getAuthor(), genre);
		
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
}
