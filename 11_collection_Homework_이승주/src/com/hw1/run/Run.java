package com.hw1.run;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.hw1.model.dto.Friend;

public class Run {

	public static void main(String[] args) {
		List<Friend> friendList = new ArrayList<Friend>();
		
		friendList.add(new Friend("짱구"));
		friendList.add(new Friend("철수"));
		friendList.add(new Friend("유리"));
		friendList.add(new Friend("훈이"));
		friendList.add(new Friend("맹구"));
		
		Random random = new Random();
		
		System.out.println(friendList.get(random.nextInt(5)).getName() + "가 떡잎방범대 대장이다!");
	}
}
