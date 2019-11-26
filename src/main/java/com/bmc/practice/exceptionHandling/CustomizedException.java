package com.bmc.practice.exceptionHandling;

public class CustomizedException {

	public static void main(String[] args) {
		
		int age = Integer.parseInt(args[0]);
		if(age > 60)
			throw new TooOldException("Too Old");
		if(age < 18)
			throw new TooYoungException("Too Young");
		else
			System.out.println("Right Age");;
	}
}

class TooYoungException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	TooYoungException(String s) {
		super(s);
	}
}

class TooOldException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3818318151944393264L;

	TooOldException(String s) {	
		super(s);
	}
}
