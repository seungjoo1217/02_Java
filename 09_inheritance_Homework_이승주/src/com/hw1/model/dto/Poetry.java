package com.hw1.model.dto;

public class Poetry extends Book{

	private int numberOfPoems;
	
	public Poetry() {}
	
	public Poetry(String title, String author, int numberOfPoems) {
		super(title, author);
		this.numberOfPoems = numberOfPoems;
	}

	public int getNumberOfPoems() {
		return numberOfPoems;
	}

	public void setNumberOfPoems(int numberOfPoems) {
		this.numberOfPoems = numberOfPoems;
	}

	@Override
	public void displayInfo() {
		System.out.printf("[%s] 제목 : %s / 저자 : %s / 장르 : %d\n", "시집", super.getTitle(), super.getAuthor(), numberOfPoems);
		
	}
	
	
}
