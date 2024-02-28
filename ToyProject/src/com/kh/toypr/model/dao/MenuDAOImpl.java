package com.kh.toypr.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.kh.toypr.model.dto.Member;

public class MenuDAOImpl implements MenuDAO{

	private final String FILE_PATH = "/io_test/Menu.dat";
	
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	
	private Set<Map<String, Object>> MenuSet = null;
	
	public MenuDAOImpl() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File(FILE_PATH);
		
		if(file.exists()) {
			
			try {
				ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
				
				MenuSet = (LinkedHashSet<Map<String, Object>>)ois.readObject();
				
			} finally {
				if(ois != null) ois.close();
			}
		} else {
			
			File directory = new File("/io_test");
			if( !directory.exists()) directory.mkdir();
			
			
			MenuSet = new LinkedHashSet<Map<String, Object>>();
			
			Member member1 = new Member("user01", "pass01", 1111, "이승주", 23, 'F', 170, 53, 0);
			MenuSet.add(addMap(member1));
			
			Member member2 = new Member("user02", "pass02", 2222, "꼬부기", 30, 'M', 180, 77, 0);
			MenuSet.add(addMap(member2));
			
			try {

				oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
				oos.writeObject(MenuSet);
				
			} finally {
				
				if(oos != null) oos.close();
				
			}
			
			System.out.println("*** MenuSet.dat 파일 생성 완료 ***");


			
		}
		

	}
	
	@Override
	public void saveFile() throws Exception {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
			oos.writeObject(MenuSet);
		} finally {
			oos.close();
		}
		
	}
	
	
	public Map<String, Object> addMap(Member member){
		Map<String, Object> MenuMap = new HashMap<String, Object>();
		
		MenuMap.put("ID", member.getId());
		MenuMap.put("PASSWORD", member.getPw());
		MenuMap.put("MEMBERNUM", member.getMemberNum());
		MenuMap.put("NAME", member.getName());
		MenuMap.put("AGE", member.getAge());
		MenuMap.put("GENDER", member.getGender());
		MenuMap.put("HEIGHT", member.getHeight());
		MenuMap.put("WEIGHT", member.getWeight());
		MenuMap.put("ATTENDANCE", member.getAttendance());
		
		return MenuMap;
		
	}
	
	
	// -----------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------

	
	@Override
	public Map<String, Object> login(String id, String pw) {
		
		for(Map<String, Object> member : MenuSet) {
			if(member.get("ID").equals(id) && member.get("PASSWORD").equals(pw)) {
				return member;
			}
		}
		return null;
	}
	
	@Override
	public Map<String, Object> searchMember(int num) {

		for(Map<String, Object> member : MenuSet) {
			if(member.get("MEMBERNUM").equals(num)) {
				return member;
			}
		}
		return null;
	}
	
	
	
	
	
	
	// -----------------------------------------------------------------------------------------
	// -------------------------------------관리자메뉴---------------------------------------------
	
	
	

	@Override
	public Set<Map<String, Object>> viewAllMember() {
		
		return MenuSet;
	}



	@Override
	public int addMember(String id, String pw, int num, String name, int age, char gender, int height, int weight) throws Exception {
		Map<String, Object> newMember = addMap(new Member(id, pw, num, name, age, gender, height, weight, 0));
				
		if(MenuSet.add(newMember)) {
			saveFile();
			
			return MenuSet.size()-1;
		}
		return -1;
	}


	@Override
	public int removeMember(Map<String, Object> memberMap) throws Exception {
		
		for(Map<String, Object> member : MenuSet) {
			if(member == memberMap) {
				if(MenuSet.remove(member)) {
					saveFile();
					
					return 0;
				}
			}

		}
	
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
	// -----------------------------------------------------------------------------------------
	// --------------------------------------멤버메뉴----------------------------------------------
	
	
	
	
	@Override
	public Map<String, Object> viewPersonalInformation(Map<String, Object> member) {
		
		for(Map<String, Object> members : MenuSet) {
			if(members == member) {
				return members;
			}

		}
		return null;
		
	}
	
	@Override
	public int updateMember(Map<String, Object> member, int num, String name, int age, char gender, int height, int weight) throws Exception {
		
		for(Map<String, Object> members : MenuSet) {
			if(members == member) {
				members.replace("MEMBERNUM", num);
				members.replace("NAME", name);
				members.replace("AGE", age);
				members.replace("GENDER", gender);
				members.replace("HEIGHT", height);
				members.replace("WEIGHT", weight);
				
				saveFile();
				
				if(members != null) return 0;
			}

		}
		return -1;
	}
	

	@Override
	public Map<String, Object> BMI(Map<String, Object> memberMap) {

		for(Map<String, Object> member : MenuSet) {
			if(member == memberMap) {
				return member;
			}

		}
		return null;
	}



	@Override
	public Map<String, Object> attendance(String id, String pw) throws Exception {
		
		for(Map<String, Object> member : MenuSet) {
			if(member.get("ID").equals(id) && member.get("PASSWORD").equals(pw)) {
				int count = (int)member.get("ATTENDANCE");
				member.replace("ATTENDANCE", count+1);
				
				saveFile();
				
				return member;
			}
		}
		return null;
	}


	
	
	
	
	
}