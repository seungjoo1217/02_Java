package edu.kh.oop.practice.model.service;

import edu.kh.oop.practice.mocel.vo.Hero;

public class HeroService {

	public void ex1() {
		Hero hero1 = new Hero();
		
		hero1.setNickName("타케미치");
		hero1.setJob("용사");
		hero1.setHp(10);
		hero1.setMp(10);
		hero1.setLevel(1);
		hero1.setExp(0);
		
		System.out.println(hero1.getNickName());
		System.out.println(hero1.getJob());
		System.out.println(hero1.getHp());
		System.out.println(hero1.getMp());
		System.out.println(hero1.getLevel());
		System.out.println(hero1.getExp());
		
		hero1.attack(30);
		hero1.magicJump();
		
		System.out.println("=============================");
		
		
		Hero hero2 = new Hero();
		
		hero2.setNickName("치후유");
		hero2.setJob("마법사");
		hero2.setHp(30);
		hero2.setMp(20);
		hero2.setLevel(5);
		hero2.setExp(10);
		
		System.out.println(hero2.getNickName());
		System.out.println(hero2.getJob());
		System.out.println(hero2.getHp());
		System.out.println(hero2.getMp());
		System.out.println(hero2.getLevel());
		System.out.println(hero2.getExp());
		
		hero2.attack(30);
		hero2.magicJump();
	}

}
