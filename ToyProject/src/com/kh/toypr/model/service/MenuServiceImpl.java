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
	
	
	
	

	@Override
	public Set<Map<String, Object>> viewAllMember() {
	
		return dao.viewAllMember();
	}

	@Override
	public int addMember(String id, String pw, int num, String name, int age, char gender, int height, int weight) throws Exception {

		return dao.addMember(id, pw, num, name, age, gender, height, weight);
	}

	@Override
	public int updateMember(Map<String, Object> member, int num, String name, int age, char gender, int height, int weight) throws Exception {

		return dao.updateMember(member, num, name, age, gender, height, weight);
	}

	@Override
	public int removeMember(Map<String, Object> memberMap) throws Exception {
		
		return dao.removeMember(memberMap);
	}
	
	@Override
	public Map<String, Object> viewPersonalInformation(Map<String, Object> member) {

		return dao.viewPersonalInformation(member);
	}

	@Override
	public int BMI(Map<String, Object> memberMap) {
		if(dao.BMI(memberMap) != null) {
			Map<String, Object> member = dao.BMI(memberMap);
			
			int BMI = ((int)member.get("WEIGHT"))/((((int)member.get("HEIGHT"))/100)^2);
			return BMI;
		}
		return 0;
	}



	@Override
	public int attendance(Map<String, Object> member) throws Exception {

		return dao.attendance(member);
	}





	@Override
	public Map<String, Object> login(String id, String pw) {
		
		return dao.login(id, pw);
	}





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


	




}
