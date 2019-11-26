package com.bmc.practice.exceptionHandling;

/*
 * Example showing the JVM default Exception Handler working
 */

public class DefaultExceptionHandler {

	public static void main(String[] args) {
		
		doStuff();
	}
	
	public static void doStuff() {
		doMoreStuff();
	}

	private static void doMoreStuff() {
		
		System.out.println(10/0); //Arithmetic exception handled by JVM default exception handler
	}
}
