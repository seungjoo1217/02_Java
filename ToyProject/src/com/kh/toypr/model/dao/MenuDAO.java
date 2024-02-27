package com.kh.toypr.model.dao;

import java.util.Map;
import java.util.Set;

import com.kh.toypr.model.dto.Member;

public interface MenuDAO {
	void saveFile() throws Exception;

	Set<Map<String, Object>> viewAllMember();

	int addMember(String id, String pw, int num, String name, int age, char gender, int height, int weight) throws Exception;

	int updateMember(Map<String, Object> member, int num, String name, int age, char gender, int height, int weight) throws Exception;

	int removeMember(Map<String, Object> memberMap) throws Exception;

	Map<String, Object> BMI(Map<String, Object> memberMap);

	int attendance(Map<String, Object> member) throws Exception;

	Map<String, Object> viewPersonalInformation(Map<String, Object> member);

	Map<String, Object> login(String id, String pw);



}
