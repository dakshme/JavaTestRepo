package com.bmc.practice.collection.set;

public class ComparableExample {

	public static void main(String[] args) {
		
		System.out.println("A".compareTo("Z")); //negative number
		System.out.println("G".compareTo("B")); // positive number
		System.out.println("A".compareTo("A")); // 0
		System.out.println("A".compareTo(null)); // Runtime Exception - NPE

	}

}
