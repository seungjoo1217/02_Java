package edu.kh.oop.basic;

public class AccountRun {
	public static void main(String[] args) {
		Account a1 = new Account();
	
		a1.setName("이승주");
		a1.setAccountNumber("1002-536-065758");
		a1.setBalance(100000);
		a1.setPassword(1234);
		
		System.out.println(a1.getName());
		System.out.println(a1.getAccountNumber());
		System.out.println(a1.getBalance());
		System.out.println(a1.getPassword());
	
		
		a1.deposit(10000);
		a1.withdraw(1234, 5000);
	}
}
