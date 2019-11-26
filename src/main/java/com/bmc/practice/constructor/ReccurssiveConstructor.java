package com.bmc.practice.constructor;

/*
 * Reccurssive constructor invocation is a compile time error in java.
 * But reccursive method invocation is runtime exception (stack over flow).
 */

public class ReccurssiveConstructor {
	
	ReccurssiveConstructor() {
		this(10);
	}
	
	ReccurssiveConstructor(int i) {
		this();
	}
	
	public static void main(String[] args) {
		System.out.println("Hello");
	}

}
