package com.kh.toypr.model.dao;

import java.util.Map;
import java.util.Set;

import com.kh.toypr.model.dto.Member;

public interface MenuDAO {
	void saveFile() throws Exception;

	Map<String, Object> login(String id, String pw);

	Map<String, Object> searchMember(int num);
	
	// -----------------------------------------------------------------------------------------
	// -------------------------------------관리자메뉴---------------------------------------------

	Set<Map<String, Object>> viewAllMember();
	
	int addMember(String id, String pw, int num, String name, int age, char gender, int height, int weight) throws Exception;
	
	int removeMember(Map<String, Object> memberMap) throws Exception;
	
	
	
	
	
	
	// -----------------------------------------------------------------------------------------
	// --------------------------------------멤버메뉴----------------------------------------------
	
	
	
	Map<String, Object> viewPersonalInformation(Map<String, Object> member);
	
	int updateMember(Map<String, Object> member, int num, String name, int age, char gender, int height, int weight) throws Exception;
	
	Map<String, Object> BMI(Map<String, Object> memberMap);

	Map<String, Object> attendance(String id, String pw) throws Exception;



}