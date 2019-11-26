package com.bmc.practice.java8.lambda;

import java.util.function.Predicate;

public class PredicateFunctionalInterface {

	public static void main(String[] args) {
		
		//Predicate<Integer> tst = num->num>10?true:false;  OR
		//as predicate by default return true or false based on expression evaluated
		Predicate<Integer> greaterTst = num->num>10;
		
		System.out.println("is 100 greater than 10- "+greaterTst.test(100));
		System.out.println("is 5 greater than 10- "+greaterTst.test(5));
		
		//to test if given number is even or not
		Predicate<Integer> evenTst = num->num%2==0;
		System.out.println("is 100 is even number- "+evenTst.test(100));
		System.out.println("is 5 is even number- "+evenTst.test(5));
	}
}
