package com.bmc.practice.exceptionHandling;

public class MultiCatchBlockExample {

	private static String s;

	public static void main(String[] args) {

		try {
			
			System.out.println(10/0);
			s = null;
			System.out.println(s.length());
		}
		catch (ArithmeticException | NullPointerException e) {
			System.out.println(e);
		}

	}

}
