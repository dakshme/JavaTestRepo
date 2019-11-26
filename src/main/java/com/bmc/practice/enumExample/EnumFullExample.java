package com.bmc.practice.enumExample;

enum Fruits {
	APPLE(170),BANANA(70),PAPAYA(40),GUAVA(90),CHIKU;
	
	int price;
	
	Fruits(int price) {
		this.price=price;
	}
	//default constructor
	Fruits() {
		this.price = 100; //default price
	}
}

public class EnumFullExample {

	public static void main(String[] args) {
		
		Fruits[] allFruit = Fruits.values();
		
		for (Fruits f : allFruit) {
			System.out.println(f+"..."+f.price);
		}

	}
}
