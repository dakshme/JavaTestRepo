package com.bmc.practice.strings;

public class Palindrome {

	public void findPalindromeStr(String inputStr ) {
		
		StringBuilder strBuilder = new StringBuilder(inputStr);
		String reverseString = strBuilder.reverse().toString();
		 
		boolean isPalindrame = inputStr.equals(reverseString);
		if (isPalindrame)
			System.out.println("String is panlindrome");    //true
		else
			System.out.println("String is not panlindrome");    //false	
	}	
}
