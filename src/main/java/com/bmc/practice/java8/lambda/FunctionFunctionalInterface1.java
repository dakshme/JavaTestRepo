package com.bmc.practice.java8.lambda;

import java.util.function.Function;

//usage of Funtion Functional interface ( apply SAM method) to get square of given input number
//apply method takes single argument and return one value

public class FunctionFunctionalInterface1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Function<Integer, Integer> funSqr = i -> { return i*i;};
		//other valid syntax
		//Function<Integer, Integer> funSqr = i -> i*i;
		
		System.out.println("Square of 2 : "+funSqr.apply(2));
		System.out.println("Square of 3 : "+funSqr.apply(3));
		System.out.println("Square of 4 : "+funSqr.apply(4));
		System.out.println("Square of 5 : "+funSqr.apply(5));
		System.out.println("Square of 6 : "+funSqr.apply(6));
	}
}
