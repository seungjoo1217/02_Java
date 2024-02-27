package com.kh.toypr.model.service;

import java.util.Map;
import java.util.Set;

public interface MenuService {

	Set<Map<String, Object>> viewAllMember();

	int addMember(String id, String pw, int num, String name, int age, char gender, int height, int weight) throws Exception;

	int updateMember(Map<String, Object> member, int num, String name, int age, char gender, int height, int weight) throws Exception;

	int removeMember(Map<String, Object> memberMap) throws Exception;

	int BMI(Map<String, Object> memberMap);

	int attendance(Map<String, Object> member) throws Exception;

	Map<String, Object> viewPersonalInformation(Map<String, Object> member);

	Map<String, Object> login(String id, String pw);

	String viewAll();



}
