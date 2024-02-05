package edu.kh.control.branch;

import java.util.Scanner;

public class BranchExample {

	Scanner sc = new Scanner(System.in);
	
	public void ex1() {
		// 1부터 10까지 1씩 증가하며 출력하는 반복문 작성
		// 단, 5를 출력하면 반복문 종료
		// 1 2 3 4 5
		
		for( int i = 1; i <= 10; i++) {
			System.out.print(i + " ");
			
			if(i == 5) {
				break;
			}
		}
	}

	public void ex2() {
		
		// 입력받은 모든 문자열을 누적
		// 단, "exit@" 입력시 문자열 누적을 종료하고 결과 출력
		
		
		String str = "";
		
		while(true) {
			System.out.print("문자열 입력(exit@ 입력 시 종료) : ");
			String input = sc.nextLine();
			
			// next() : 다음 한 단어 (띄어쓰기 포함 X)
			// nextLine() : 다음 한 줄 (띄어쓰기 포함 O)
			
			if(input.equals("exit@")) {
				// String 자료형은 비교연산자(==)로 같은 문자열인지 판별할 수 없다.
				// 비교연산자(==)는 보통 기본자료형끼리의 연산에서만 사용 가능함.
				// -> String 은 기본자료형이 아닌 참조형
				
				// ** 해결방법 : 문자열1.equals(문자열2) 으로 비교 가능 **
				break;
				
			}
			
			str += input + "\n";
			
		}
		
		System.out.println("============================");
		System.out.println(str);
		
		
		
		
	}

	public void ex3() {
		// continue : 다음 반복으로 넘어감
		
		// 1~10까지 1씩 증가하며 출력
		// 단, 3의 배수 제외
		
		for(int i = 1; i <= 10; i++) {
			
			if(i % 3 == 0) {
				continue;
			}
			
			System.out.println(i + " ");
		}
	}

	public void ex4() {
		// 1 ~ 100 까지 1씩 증가하며 출력하는 반복문
		// 단, 5의 배수는 건너뛰고
		// 증가하는 값이 40이 되었을때 반복을 멈춤
		
		for(int i = 1; i <= 100; i++) {
			if(i == 40) break;
			if(i % 5 == 0) continue;
			
			System.out.println(i);
			
		}
	}

	public void RSPGame() {
		
		// 가위바위보 게임을 할건데,
		// 몇 판할지 입력받음
		// 입력받은 판 수 만큼 반복
		// 컴퓨터 : Math.random() : 0~1미만 난수
		// 1) 1~3 사이 난수 생성
		// 2) 1이면 가위, 2이면 바위, 3이면 보 지정 (switch)
		// 컴퓨터와 플레이어 가위바위보 판별
		// 플레이어 승! / 졌습니다 ㅠㅠ
		// 매판마다 - 현재 기록 : 2승 1무 0패
		
		System.out.println("[가위 바위 보 게임~!!]");
		System.out.print("몇 판? : ");
		int input = sc.nextInt();
		
		int win = 0;
		int lose = 0;
		int pass = 0;
		for(int i = 1; i <= input; i++) {
			System.out.println(input + "번째 게임");
			System.out.print("가위/바위/보 중 하나를 입력 해주세요 : ");
			String st = sc.next();
			
			int random = (int) (Math.random() * 3 +1);
			String com = "";
			switch(random) {
			case 1 : com = "가위";break;
			case 2 : com = "바위";break;
			case 3 : com = "보";break;
			}
			
			System.out.printf("컴퓨터는 [%s]를 선택했습니다.\n",com);
			
			if(st.equals("가위")) {
				if(com.equals("가위")) {
					System.out.println("비겼습니다");
					pass ++;
				}else if(com.equals("바위")) {
					System.out.println("졌습니다 ㅜㅜ");
					lose ++;
				}else if(com.equals("보")) {
					System.out.println("플레이어 승!");
					win ++;
				}
			}else if(st.equals("바위")) {
				if(com.equals("가위")) {
					System.out.println("플레이어 승!");
					win ++;
				}else if(com.equals("바위")) {
					System.out.println("비겼습니다");
					pass ++;
				}else if(com.equals("보")) {
					System.out.println("졌습니다 ㅜㅜ");
					lose ++;
				}
			}else if(st.equals("보")) {
				if(com.equals("가위")) {
					System.out.println("졌습니다 ㅜㅜ");
					lose ++;
				}else if(com.equals("바위")) {
					System.out.println("플레이어 승!");
					win ++;
				}else if(com.equals("보")) {
					System.out.println("비겼습니다");
					pass ++;
				}
			}
			System.out.printf("현재 기록 : %d승 %d무 %d패\n\n",win,pass,lose);
		}
	}
	
	
}
