package com.kh.toypr.model.service;

import java.util.Map;
import java.util.Set;

public interface MenuService {

	Map<String, Object> login(String id, String pw);

	Map<String, Object> searchMember(int num);
	
	// -----------------------------------------------------------------------------------------
	// -------------------------------------관리자메뉴---------------------------------------------

	String viewAll();
	
	Set<Map<String, Object>> viewAllMember();
	
	int addMember(String id, String pw, int num, String name, int age, char gender, int height, int weight) throws Exception;
	
	int removeMember(Map<String, Object> memberMap) throws Exception;
	
	
	
	
	
	
	// -----------------------------------------------------------------------------------------
	// --------------------------------------멤버메뉴----------------------------------------------
	
	
	Map<String, Object> viewPersonalInformation(Map<String, Object> member);

	int updateMember(Map<String, Object> member, int num, String name, int age, char gender, int height, int weight) throws Exception;
	
	String BMI(Map<String, Object> memberMap);
	
	
	int attendance(Map<String, Object> member, String id, String pw) throws Exception;


}