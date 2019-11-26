package com.bmc.practice.constructor;

/*
 * Example of overloaded constructors
 */

public class OverLoadedConstructor {
	
	OverLoadedConstructor() {
		this (10);
		System.out.println("no arg constructor");
	}
	
	OverLoadedConstructor(int i) {
		this (10.5);
		System.out.println("integer arg constructor");
	}
	
	OverLoadedConstructor(double d) {
		System.out.println("double arg constructor");
	}
	
	public static void main (String[] args) {
		OverLoadedConstructor obj1 = new OverLoadedConstructor();
		
		System.out.println("***************");
		OverLoadedConstructor obj2 = new OverLoadedConstructor(10);
		
		System.out.println("***************");
		OverLoadedConstructor obj3 = new OverLoadedConstructor(10.5);
		
		System.out.println("long arg promoted to double type");
		OverLoadedConstructor obj4 = new OverLoadedConstructor(10l);
		
	}

}
