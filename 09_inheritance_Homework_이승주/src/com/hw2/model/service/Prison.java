package com.hw2.model.service;

import com.hw2.model.dto.Employee;
import com.hw2.model.dto.Person;
import com.hw2.model.dto.Prisoner;

public class Prison implements ManagementSystem{

	private Prisoner[] prisoners;
	private int prisonerCount;
	
	public Prison() {}

	public Prison(int prisonerCount) {
		super();
		this.prisoners = new Prisoner[prisonerCount];
	}

	@Override
	public void addPerson(Person person) {
		boolean flag = true;
		for(int i = 0; i < prisoners.length; i++) {
			if(prisoners[i] == null) {
				flag = false;
				prisonerCount ++;
				prisoners[i] = (Prisoner) person;
				System.out.printf("수감자가 추가되었습니다 - ID : %s, 이름 : %s, 죄목 : %s\n",person.getId(), person.getName(), ((Prisoner)person).getCrime());
				break;
			}
		}
		if(flag) {
			System.out.println("인원이 모두 충원되었습니다.");
		}
	}

	@Override
	public void removePerson(String id) {
		boolean flag = true;
		for(int i = 0; i < prisonerCount; i++) {
			if(prisoners[i].getId().equals(id)) {
				prisonerCount --;
				flag = false;
				System.out.printf("수감자가 삭제되었습니다 - ID : %s, 이름 : %s, 죄목 : %s\n",prisoners[i].getId(), prisoners[i].getName(), prisoners[i].getCrime());
				for(int j = i; j < prisonerCount-i-1; j++) {
					prisoners[j] = prisoners[j+1];
				}
				break;
			}
		}
		if(flag) {
			System.out.println("해당 ID를 가진 직원을 찾을 수 없습니다.");
		}
	}

	@Override
	public void displayPerson() {
		System.out.println("전체 수감자 명단 : ");
		for(int i = 0; i < prisonerCount; i++) {
			System.out.println(prisoners[i].getInfo());
		}
	}

	public Prisoner[] getPrisoners() {
		return prisoners;
	}

	public void setPrisoners(Prisoner[] prisoners) {
		this.prisoners = prisoners;
	}

	public int getPrisonerCount() {
		return prisonerCount;
	}

	public void setPrisonerCount(int prisonerCount) {
		this.prisonerCount = prisonerCount;
	}
	
	
}
