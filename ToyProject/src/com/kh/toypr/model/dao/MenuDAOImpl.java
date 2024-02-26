package com.kh.toypr.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MenuDAOImpl {

	private final String FILE_PATH = "/io_test/Menu.dat";
	
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	
	private Map<String, Object> MenuMap = null;
	
	public MenuDAOImpl() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File(FILE_PATH);
		
		if(file.exists()) {
			
			try {
				ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
				
				MenuMap = (HashMap<String, Object>)ois.readObject();
				
			} finally {
				if(ois != null) ois.close();
			}
		} else {
			
			File directory = new File("/io_test");
			if( !directory.exists()) directory.mkdir();
			
			
			MenuMap = new HashMap<String, Object>();
			
			MenuMap.put("이름", "이승주");
			
			try {
				// 객체 출력 스트림 생성 -> 파일이 없다면 자동 생성
				oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
				oos.writeObject(todoList); // todoList를 파일로 출력
				
			} finally {
				
				if(oos != null) oos.close(); // flush() 내장되어 있어 다 밀어내고 메모리 반환(닫기)
				
			}
			
			System.out.println("*** TodoList.dat 파일 생성 완료 ***");

			
		}
		

	}
	
	
	public Map<String, Object> addMap(Member(String name, int age, String gender, int height, int weight)){
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
