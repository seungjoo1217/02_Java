package edu.kh.array.practice.service;

import java.util.Arrays;
import java.util.Scanner;

public class PracticeService {

	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		int arr[] = new int[9];
		
		int sum = 0;
		for(int i = 1; i <= arr.length; i++) {
			arr[i-1] = i;
			System.out.print(i + " ");
			
			if(i % 2 == 1) {
				sum += i;
			}
		}
		System.out.println();
		System.out.println("짝수 번째 인덱스 합 : " + sum);
	}

	public void practice2() {
		int arr[] = new int[9];
		
		int sum = 0;
		for(int i = 9; i >= 1; i--) {
			arr[9-i] = i;
			System.out.print(i + " ");
			
			if(i % 2 == 0) {
				sum += arr[9-i];
			}
		}
		System.out.println();
		System.out.println("홀수 번째 인덱스 합 : " + sum);
		
	}

	public void practice3() {
		System.out.print("양의 정수 : ");
		int input = sc.nextInt();
		
		int arr[] = new int[input];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		System.out.println(Arrays.toString(arr));
	}

	public void practice4() {
		int arr[] = new int[5];
		
		for(int i = 0; i < 5; i++) {
			System.out.print("입력 " + i + " : ");
			arr[i] = sc.nextInt();
		}
		System.out.print("검색할 값 : ");
		int input = sc.nextInt();
		
		boolean flag = false;
		for(int i = 0; i < 5; i++) {
			if(arr[i] == input) {
				System.out.println("인덱스 : " + i);
				flag = true;
			}
		}
		if(!flag) {
			System.out.println("일치하는 값이 존재하지 않습니다.");
		}
	}

	public void practice5() {
		System.out.print("문자열 : ");
		String input = sc.next();
		
		char arr[] = new char[input.length()];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = input.charAt(i);
		}
		System.out.print("문자 : ");
		char ch = sc.next().charAt(0);
		
		String message = "";
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == ch) {
				message += i;
				message += " ";
				count ++;
			}
		}
		System.out.println(input + "에 " + ch + "가 존재하는 위치(인덱스) : " + message);
		System.out.println(ch + "의 개수 : " + count);
	}

	public void practice6() {
		System.out.print("정수 : ");
		int input = sc.nextInt();
		
		int arr[] = new int[input];
		
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			System.out.print("배열 " + i + "번째 인덱스에 넣을 값 : ");
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("총 합 : " + sum);
	}

	public void practice7() {
		System.out.print("주민등록번호(-포함) : ");
		String input = sc.next();
		
		char[] arr = new char[input.length()];
		
		for(int i = 0; i < arr.length; i++) {
			if(i >= 9) {
				arr[i] = '*';
			}else {
				arr[i] = input.charAt(i);			
			}
		}
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i]);
		}
		System.out.println();
	}
		
	public void practice8() {
		
		int input = 0;
		while(true) {
			System.out.print("정수 : ");
			input = sc.nextInt();
			
			if(input >= 3 && input % 2 == 1) break;
			
			System.out.println("다시 입력하세요.");
		}
		int arr[] = new int[input];
		
		for(int i = 0;i < arr.length; i++ ) {
			if(i < (input/2 + 1)) {
				arr[i] = i+1;
			}else {
				arr[i] = (input)-i;
			}
		}
		System.out.println(Arrays.toString(arr));
		

	}

	public void practice9() {
		int arr[] = new int[10];
		
		for(int i = 0; i < arr.length; i++) {
			int random = (int)(Math.random()*10 + 1);
			arr[i] = random;
		}
		
		String message = "발생한 난수 : ";
		for(int i = 0; i < arr.length; i++) {
			message += (arr[i] + " ");
		}
		System.out.println(message);
	}

	public void practice10() {
		int arr[] = new int[10];
		
		for(int i = 0; i < arr.length; i++) {
			int random = (int)(Math.random()*10 + 1);
			arr[i] = random;
		}
		
		String message = "발생한 난수 : ";
		for(int i = 0; i < arr.length; i++) {
			message += (arr[i] + " ");
		}
		System.out.println(message);
		
		
		int max = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		System.out.println("최대값 : " + max);
		
		int min = 100;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i]<min) {
				min = arr[i];
			}
		}
		System.out.println("최소값 : " + min);
	}

	public void practice11() {
		int arr[] = new int[10];
		
		for(int i = 0; i < arr.length; i++) {
			int random = (int)(Math.random()*10 + 1);
			arr[i] = random;
			
			for(int j = 0; j < i; j++) {
				if(arr[j] == arr[i]) {
					i--;
				}
			}
		}
		
		String message = "";
		for(int i = 0; i < arr.length; i++) {
			message += arr[i] + " ";
		}
		System.out.println(message);
	}

	public void practice12() {
		int arr[] = new int[6];
		
		for(int i = 0; i < arr.length; i++) {
			int random = (int) (Math.random()*45 + 1);
			arr[i] = random;
			
			for(int j = 0; j < i; j++) {
				if(arr[j] == arr[i]) {
					i--;
				}
			}
		}
		Arrays.sort(arr);
		
		String message = "";
		for(int i = 0; i < arr.length; i++) {
			message += arr[i] + " ";
		}
		System.out.println(message);
	}

	public void practice13() {
		System.out.print("문자열 : ");
		String input =sc.next();
		
		char arr[] = new char[input.length()];
		
		int count = input.length();
		int add = 0;
		for(int i = 0; i < arr.length; i++) {
			arr[i] = input.charAt(i);
			for(int j = 0; j < i; j++) {
				if(arr[j] == arr[i]) {
					count--;
					add ++;
				}
			}
		}

		//문자 개수 : count = 8
		
		
		char arr_result[] = new char[1];
		arr_result[0] = arr[0];
		
		int num = 0;
		for(int i = 0; i < count+add; i++) {
			boolean flag = false;
			
			for(int j = 0; j < i; j++) {
				if(arr[j] == arr[i]) {
					flag = true;
				}
			}
			
			if(flag == false) {
				num ++;
				char arr_new[] = new char[num];
				for(int z = 0; z < num; z ++) {
					if(z < num-1) {
						arr_new[z] = arr_result[z];
					}else {
						arr_new[z] = arr[i];
					}
				}
				arr_result = arr_new;
			}
		}
	
		System.out.println("문자열에 있는 문자 : " + Arrays.toString(arr_result));
		System.out.println("문자 개수 : " + count);
		

	}

	public void practice14() {
		System.out.print("배열의 크기를 입력하세요 : ");
		String arr[] = new String[sc.nextInt()];
		sc.nextLine();
		

		for(int i = 0; i < arr.length; i++) {
			System.out.print((i+1) + "번째 문자열 : ");
			arr[i] = sc.nextLine();
			}
		
		char ch = 0;
		int count = arr.length;
		while(true) {
			System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
			ch = sc.next().charAt(0);
			if(ch != 'y')break;
			System.out.print("더 입력하고 싶은 개수 : ");
			int num = sc.nextInt();
			sc.nextLine();
			count += num;
			String arr_new[] = new String[count];
			
			for(int i = 0; i < count; i++) {
				if(i < arr.length) {
					arr_new[i] = arr[i];
				}else {
					System.out.print((i+1) + "번째 문자열 : ");
					arr_new[i] = sc.nextLine();
				}
			
			}
			arr= arr_new;
		}
		System.out.println(Arrays.toString(arr));
		
	}
}
