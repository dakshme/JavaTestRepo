package com.bmc.practice.strings;

public class ReadCharsFromAString {
	
	public void getFirstFewCharacter() {
		String input = "123456789";     //input string
		String firstFourChars = "";     //substring containing first 4 characters
		 
		if (input.length() > 4) {
		    firstFourChars = input.substring(0, 4);
		}
		else {
		    firstFourChars = input;
		}
		 
		System.out.println("First four character are: "+firstFourChars);
		
		System.out.println("First character is: "+input.substring(0, 1));
	}

	public void getLastFewCharacter() {
		String input = "123456789";     //input string
		String lastFourDigits = "";     //substring containing last 4 characters
		 
		if (input.length() > 4){
		    lastFourDigits = input.substring(input.length() - 4);
		}
		else {
		    lastFourDigits = input;
		}
		 
		System.out.println("Last for charaters are: "+lastFourDigits);

	}
}
