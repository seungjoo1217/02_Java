package edu.kh.oop.basic;

// 계좌 클래스
public class Account {
	
	// 속성(값)
	private String name;
	private String accountNumber;
	private long balance;
	private int password;
	
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
	public long getBalance() {
		return balance;
	}
	
	
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	
	public int getPassword() {
		return password;
	}
	
	
	public void setPassword(int password) {
		this.password = password;
	}
	
	
	
	
	
	// 전달받은 금액을 잔액에 누적한 후, 현재 잔액을 콘솔에 출력
	public void deposit(int amount) {
		this.balance += amount;
		System.out.println("현재 잔액 : " + balance);
	}
	
	
	// 비밀번호와 출금할 금액을 전달받아와,
	// 조건에 맞으면 잔액에서 차감 후 현재 잔액 출력
	// 1) 비밀번호와 일치하지 않으면 "비밀번호 불일치" 출력
	//2) 출금할 금액이 잔액보다 크면 "잔액 부족" 출력
	public void withdraw(int pw,int amount) {
		if(this.password != pw) {
			System.out.println("비밀번호 불일치");
			return;
		}else {
			if(this.balance < amount) {
				System.out.println("잔액 부족");
			}else {
				this.balance -= amount;
				System.out.println("현재 잔액 : " +balance);
			}
		}
		
	}
	

}
	
	
	
	

