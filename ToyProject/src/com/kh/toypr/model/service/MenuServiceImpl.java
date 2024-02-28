package com.kh.toypr.model.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import com.kh.toypr.model.dao.MenuDAO;
import com.kh.toypr.model.dao.MenuDAOImpl;
import com.kh.toypr.model.dto.Member;

public class MenuServiceImpl implements MenuService {
	
	private MenuDAO dao = null;
	
	public MenuServiceImpl() throws FileNotFoundException, ClassNotFoundException, IOException {
		dao = new MenuDAOImpl();
	}
	
	
	// -----------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------
	
	
	@Override
	public Map<String, Object> login(String id, String pw) {
		
		return dao.login(id, pw);
	}
	
	@Override
	public Map<String, Object> searchMember(int num) {
		
		if(dao.searchMember(num) != null) {
			return dao.searchMember(num);
		}

		return null;
	}
	
	
	
	// -----------------------------------------------------------------------------------------
	// -------------------------------------관리자메뉴---------------------------------------------
	
	
	
	@Override
	public String viewAll() {
			
			StringBuilder sb = new StringBuilder();
			int count = 1;
			for(Map<String, Object> member : dao.viewAllMember()) {
				
				sb.append("회원 " + (count++) + " : " + member.get("NAME") + "\n");
				sb.append(member);
				sb.append("\n");
			}
		
			return sb.toString();
	}

	@Override
	public Set<Map<String, Object>> viewAllMember() {
	
		return dao.viewAllMember();
	}

	@Override
	public int addMember(String id, String pw, int num, String name, int age, char gender, int height, int weight) throws Exception {

		return dao.addMember(id, pw, num, name, age, gender, height, weight);
	}


	@Override
	public int removeMember(Map<String, Object> memberMap) throws Exception {
		
		return dao.removeMember(memberMap);
	}
	
	
	
	
	
	
	
	
	
	// -----------------------------------------------------------------------------------------
	// --------------------------------------멤버메뉴----------------------------------------------
	
	
	@Override
	public Map<String, Object> viewPersonalInformation(Map<String, Object> member) {

		return dao.viewPersonalInformation(member);
	}
	
	
	@Override
	public int updateMember(Map<String, Object> member, int num, String name, int age, char gender, int height, int weight) throws Exception {

		return dao.updateMember(member, num, name, age, gender, height, weight);
	}

	@Override
	public String BMI(Map<String, Object> memberMap) {
		if(dao.BMI(memberMap) != null) {
			Map<String, Object> member = dao.BMI(memberMap);
			
			int BMI = ((int)member.get("WEIGHT"))/((((int)member.get("HEIGHT"))/100)^2);
			
			String str = "";
			if(BMI < 18.5) {
				str = "저체중";
				
			}else if(BMI >= 18.5 && BMI < 23) {
				str = "정상체중";
				
			}else if(BMI >= 23 && BMI < 25) {
				str = "과체중";
				
			}else if(BMI >= 25 && BMI < 30) {
				str = "경도비만";
				
			}else if(BMI >= 30 && BMI < 35) {
				str = "중등도비만";
				
			}else if(BMI >= 35) {
				str = "고도비만";
				
			}else if(BMI == 0) {
				return "[출력 실패]";
			}
			
			return String.format("%s's BMI : %d [%s]\n", (String)member.get("NAME"), BMI, str);
		}
		
		return "[출력 실패]";
	}



	@Override
	public int attendance(Map<String, Object> member, String id, String pw) throws Exception {
		
		Map<String, Object> mem = dao.attendance(id, pw);
		
		if(mem == member ) {
			return (int)mem.get("ATTENDANCE");
		}
		
		return -1;
	}


	




}
