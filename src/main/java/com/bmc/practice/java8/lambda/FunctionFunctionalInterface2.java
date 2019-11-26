package com.bmc.practice.java8.lambda;

import java.util.function.Function;

//usage of Function Functional interface ( apply SAM method) to get remove spaces from given input string
//apply method takes single argument and return one value

public class FunctionFunctionalInterface2 {

	public static void main(String[] args) {

		String input = "He Is The Best Hero Of The Year And Era";
		
		Function<String, String> strTrim = s -> {
	
			return s.replaceAll(" ", "");
			
			//OR by converting to char array			
//				char[] result= new char[input.length()];
//				int i=0;
//				for (char c :s.toCharArray()) {
//					if(c!=' ') {
//						result[i]=c;
//						i++;
//					}
//				}				
//				return String.valueOf(result);
//				//Or
//				//return new String(result);
			};
			
			System.out.println("Original String: "+input);
			System.out.println("Returned String: "+strTrim.apply(input));
	}
}
