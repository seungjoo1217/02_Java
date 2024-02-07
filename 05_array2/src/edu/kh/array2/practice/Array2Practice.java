package edu.kh.array2.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Array2Practice {

	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		
		int arr[][] = new int[3][3];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.printf("(%d, %d)", i, j);
			}
			System.out.println();
		}
	}

	public void practice2() {
		int arr[][] = new int[4][4];
		
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++){
				count ++;
				System.out.printf("%2d ", count);
			}
			System.out.println();
		}
	}

	public void practice3() {
		int arr[][] = new int[4][4];
		
		int count = 16;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++){
				System.out.printf("%2d ", count);
				count --;
			}
			System.out.println();
		}
	}

	public void practice4() {
		int arr[][] = new int[4][4];
		
		for(int i = 0; i < arr.length; i++) {
			if(i < arr.length-1) {
				int col_sum = 0;
				for(int j = 0; j < arr[i].length; j++) {
					if(j < arr[i].length-1) {
						int random = (int)(Math.random()*10 +1);
						arr[i][j] = random;
						System.out.printf("%2d ", random);
						col_sum += random;
					}else {
						arr[i][j] = col_sum;
						System.out.printf("%2d", col_sum);
					}
				}
				System.out.println();
			}else {
				for(int j = 0; j < arr[i].length; j++) {
					int row_sum = 0;
					for(int z = 0; z < arr.length-1; z++) {
						row_sum += arr[z][j];
					}
					System.out.printf("%2d ", row_sum);
				}
			}
		}
	}

	public void practice5() {
		
		int colSize = 0;
		do {
			System.out.print("행 크기 : ");
			colSize = sc.nextInt();
		}while(colSize < 1 || colSize > 10);
		
		int rowSize = 0;
		do {
			System.out.print("열 크기 : ");
			rowSize = sc.nextInt();
		}while(rowSize < 1 || rowSize > 10);
		
		char arr[][] = new char[colSize][rowSize];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				int random = (int) (Math.random()*26 + 65);
				arr[i][j] += random;
				System.out.print((char)random + " ");
			}
			System.out.println();
		}
		
		
	}

	public void practice6() {
		System.out.print("행의 크기 : ");
		int input = sc.nextInt();
		char arr[][] = new char[input][];
		
		int count = 0;
		for(int i = 0; i < arr.length; i ++) {
			System.out.print(i + "열의 크기 : ");
			int rowSize = sc.nextInt();
			count += rowSize;
			
			arr[i] = new char[rowSize];
		}
		
		char i = 'a';
		for(int j = 0; j < arr.length; j++) {
			for(int z = 0; z < arr[j].length; z++) {
				arr[j][z] = (char)i;
				System.out.printf("%c ", (char)i);
				i++;
			}
			System.out.println();
		}
	}
}
