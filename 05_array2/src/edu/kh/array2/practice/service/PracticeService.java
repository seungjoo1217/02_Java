package edu.kh.array2.practice.service;

import java.util.Arrays;
import java.util.Scanner;

public class PracticeService {

	Scanner sc = new Scanner(System.in);
	
	public void practice7() {
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배",
			"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
			
			String arr1[][] = new String[3][2];
			String arr2[][] = new String[3][2];
			
			System.out.println("== 1분단 ==");
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < arr1.length; j++) {
					for(int z = 0; z < arr1[j].length; z++) {
						arr1[j][z] = students[i];
						System.out.print(arr1[j][z] + "  ");
						i++;
					}
					System.out.println();
				}
			}
			System.out.println("== 2분단 ==");
			for(int i = 6; i < students.length; i++) {
				for(int j = 0; j < arr2.length; j++) {
					for(int z = 0; z < arr2[j].length; z++) {
						arr2[j][z] = students[i];
						System.out.print(arr2[j][z] + "  ");
						i++;
					}
					System.out.println();
				}
			}
		}

	public void practice8() {
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배",
				"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
				
				String arr1[][] = new String[3][2];
				String arr2[][] = new String[3][2];
				
				System.out.println("== 1분단 ==");
				for(int i = 0; i < 6; i++) {
					for(int j = 0; j < arr1.length; j++) {
						for(int z = 0; z < arr1[j].length; z++) {
							arr1[j][z] = students[i];
							System.out.print(arr1[j][z] + "  ");
							i++;
						}
						System.out.println();
					}
				}
				System.out.println("== 2분단 ==");
				for(int i = 6; i < students.length; i++) {
					for(int j = 0; j < arr2.length; j++) {
						for(int z = 0; z < arr2[j].length; z++) {
							arr2[j][z] = students[i];
							System.out.print(arr2[j][z] + "  ");
							i++;
						}
						System.out.println();
					}
				}
				
				System.out.print("검색할 학생 이름을 입력하세요 : ");
				String input = sc.next();
				
				boolean flag = false;
				int count = 0;
				int iK = 0;
				for(int i = 0; i < arr1.length; i++) {
					for(int j = 0; j < arr1[i].length; j++) {
						if(arr1[i][j].equals(input)){
							flag = true;
							iK = i;
							if(j == 0) {
								count = 0;
							}else {
								count = 1;
							}
						}
					}
					
				}
				for(int i = 0; i < arr1.length; i++) {
					for(int j = 0; j < arr2[i].length; j++) {
						if(arr2[i][j].equals(input)){
							iK = i;
							if(j == 0) {
								count = 0;
							}else {
								count = 1;
							}
						}
					}
					
				}
				if(flag == true && count == 0) {
					System.out.printf("검색하신 %s 학생은 1분단 %d번째 줄 왼쪽에 있습니다.\n",input,iK+1);
				}else if(flag == true && count == 1) {
					System.out.printf("검색하신 %s 학생은 1분단 %d번째 줄 오른쪽에 있습니다.\n",input,iK+1);
				}else if(flag == false && count == 0) {
					System.out.printf("검색하신 %s 학생은 2분단 %d번째 줄 오른쪽에 있습니다.\n",input,iK+1);
				}else if(flag == false && count == 1) {
					System.out.printf("검색하신 %s 학생은 2분단 %d번째 줄 오른쪽에 있습니다.\n",input,iK+1);
				}
				
				
				
				
				
				
				
				
				
		}

	public void practice9() {
		System.out.print("행 인덱스 입력 : ");
		int input1 = sc.nextInt();
		System.out.print("열 인덱스 입력 : ");
		int input2 = sc.nextInt();
		
		
		char arr[][] = new char[6][6];
		
		char arr2[] = new char[5];
		arr2[0] = '0';
		arr2[1] = '1';
		arr2[2] = '2';
		arr2[3] = '3';
		arr2[4] = '4';
		
		
		int num1 = 0;
		int num2 = 0;
		for(int i = 0; i <arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = ' ';
				if(i == 0 && j > 0) {
					arr[i][j] = arr2[num1];
					num1 ++;
				}
				else if(j == 0 && i > 0) {
					arr[i][j] = arr2[num2];
					num2 ++;
				}else if(i == input1+1 && j == input2+1) {
					arr[i][j] = 'x';
				}
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void practice10() {
		while(true) {
			System.out.print("행 인덱스 입력 : ");
			int input1 = sc.nextInt();
			if(input1 == 99)break;
			System.out.print("열 인덱스 입력 : ");
			int input2 = sc.nextInt();
			
			
			
			char arr[][] = new char[6][6];
			
			char arr2[] = new char[5];
			arr2[0] = '0';
			arr2[1] = '1';
			arr2[2] = '2';
			arr2[3] = '3';
			arr2[4] = '4';
			
			
			int num1 = 0;
			int num2 = 0;
			for(int i = 0; i <arr.length; i++) {
				for(int j = 0; j < arr[i].length; j++) {
					arr[i][j] = ' ';
					if(i == 0 && j > 0) {
						arr[i][j] = arr2[num1];
						num1 ++;
					}
					else if(j == 0 && i > 0) {
						arr[i][j] = arr2[num2];
						num2 ++;
					}else if(i == input1+1 && j == input2+1) {
						arr[i][j] = 'x';
					}
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
