package com.hw4.controller;

import com.hw4.model.vo.Member;

public class MemberController {

	public int SIZE = 10; // 최대 회원 수 상수필드로 10 초기화
	
	private int memberCount; // 현재 회원 수 필드
	private Member[] mem = new Member[SIZE]; // 회원들의 정보를 담는 객체 배열

	
	// 초기화 블럭을 이용하여 기본적인 회원 5명의 정보 초기화, memberCount 수 5 초기화
	
	
	{
		mem[0] = new Member("user01", "pass01", "김유신", 20, 'M', "kim12@naver.com");
		mem[1] = new Member("user02", "pass02", "이순신", 60, 'M', "lee2@naver.com");
		mem[2] = new Member("user03", "pass03", "유관순", 17, 'F', "yo5@@hanmail.net");
		mem[3] = new Member("user04", "pass04", "연개소문", 57, 'M', "kim12@gmail.com");
		mem[4] = new Member("user05", "pass05", "신사임당", 45, 'F', "kim12@naver.com");
		memberCount = 5;
	}
	
	
	public int getMemberCount() {
		// memberCount 리턴
		return memberCount;
	}
	
	
	public Member[] getMem() {
		// mem 주소 값 리턴
		return mem;
	}
	
	
	public Member checkld(String userId) {
		
		Member m = null; // 아이디로 검색된 결과를 담을 변수 초기화
		
		
		// mem 에서 매개변수로 전달받은 userId와 동일한 아이디를 가지고 있는 회원을 m에 대입
		for(int i = 0; i < memberCount; i++) {
			if(mem[i].getUserId().equals(userId)) {
				m = mem[i];
			}
		}
		// m 리턴
		return m;
		
	}
	
	public void insertMember(String id, String pw, String name, int age, char gender, String email) {
		if(memberCount > 10) {
			return;
		}
		
		// 매개변수로 전달받은 회원정보를 mem 객체에 추가
		for(int i = 0; i < mem.length; i++) {
			if(mem[i] == null) {
				mem[i] = new Member(id, pw, name, age, gender, email);
			}
		}
		// memberCount 1증가
		memberCount ++;
		
	}
	
	public Member searchMember(int menu, String search) {
		
		
		Member searchMember = null; // 검색된 회원 정보를 담을 변수 초기화
		
		// 매개변수로 전달받은 search 문자열을 menu 번호에 따라
		
		
		// 1 인 경우 아이디로 검색 후 결과를 searchMember에 대입하고
		// 2 인 경우 이름으로 검색 후 결과를 searchMember에 대입하고
		// 3 인 경우 이메일로 검색 후 결과를 searchMember에 대입하고
		
		switch(menu) {
		case 1 : 
			for(int i = 0; i < memberCount; i++) {
				if(mem[i].getUserId().equals(search)) {
					searchMember = mem[i];
				}
			}; break;
			
		case 2: 
			for(int i = 0; i < memberCount; i++) {
				if(mem[i].getName().equals(search)) {
					searchMember = mem[i];
				}
			}; break;
			
		case 3: 
			for(int i = 0; i < memberCount; i++) {
				if(mem[i].getEmail().equals(search)) {
					searchMember = mem[i];
				}
			}; break;
		}
		
		
		// searchMember 주소 값 리턴
		return searchMember;
		
	}
	
	public void updateMember(Member m, int menu, String update) {
		
		
		// 매개변수로 전달받은 m 회원과 변경 내용인 update 문자열을 menu에 따라
		
		
		// 1 인 경우 setter 메소드를 이용하여 m의 비밀번호를 update 문자열로 변경
		// 2 인 경우 setter 메소드를 이용하여 m의 이름을 update 문자열로 변경
		// 3 인 경우 setter 메소드를 이용하여 m의 이메일을 update 문자열로 변경
		
		switch(menu) {
		case 1 : m.setUserPwd(update); break;
		case 2 : m.setName(update); break;
		case 3 : m.setEmail(update); break;
		}
		
	}
	
	public void deleteMember(String userId) {
		
		
		
		// 매개변수로 전달받은 userId가 mem에 존재하는 경우 해당 회원 삭제 후
		for(int i = 0; i < mem.length; i++) {
			if(mem[i].getUserId().equals(userId)) {
				// 다음 인덱스 객체들의 정보를 한 칸씩 앞으로 이동 시킴
				for(int j = i; j < mem.length; j++) {
					if(j == mem.length-1) {
						mem[j] = null;
					}else {
						mem[j] = mem[j+1];
					}
				}
			}
		}
		// 실행 시 NullPointerException 발생할 수 있음 -> 왜그런지 생각해보고 해결하시오
		
		
		// memberCount 1 감소
		memberCount --;
		
	}
	
	
	public Member[] sortIdAsc() {

		// 기존의 회원 객체 배열(mem)을 변경하지 않고 단지 정렬된 결과만을 보여주기 위해
		// 기존의 배열 복사해서 사용 (clone(), System.arraycopy() 둘 중 하나 사용해서 복사)
		Member copy[] = new Member[memberCount];
		System.arraycopy(mem, 0, copy, 0, memberCount);
		
		// copy 배열을 아이디 별 오름차순 정렬 진행 --> HINT : compareTo() 메소드 활용
		Member copy2[] = new Member[memberCount];
		for(int i = 0; i < copy.length; i++) {
			
			for(int j = 0; j < i; j++) {
				if(copy[j].getUserId().compareTo(copy[i].getUserId()) == 1) {
					copy[i] = copy2[j];
					break;
				}else {
					copy
				}
			}
		}
		// copy 주소 값 리턴
		return copy;
	}
	
	
	public Member[] sortIdDesc() {
		
		// 위와 동일한 방식이지만 내림차순으로 장렬 후 주소 값 리턴

	}
	
	
	public Member[] sortAgeAsc() {
		// 위와 동일한 방식이지만 나이별 오름차순 정렬 후 주소값 리턴
		// (숫자 비쇼이기 때문에 compareTo 사용X)

	}
	
	public Member[] sortAgeDesc() {
		// 위와 동일한 방식이지만 내림차순으로 정렬 후 주소 값 리턴

	}
	
	public Member[] sortGenderDesc() {
		// 위와 동일한 방식이지만 성별 별 내림차순으로 정렬 후 주소 값 리턴
		// (남여 순으로 정렬)

	}
	
	
	
	
	
	
	
	
}
