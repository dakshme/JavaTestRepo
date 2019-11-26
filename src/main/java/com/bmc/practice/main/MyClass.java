package com.bmc.practice.main;

import com.bmc.practice.strings.FindDuplicate;
import com.bmc.practice.strings.Palindrome;
import com.bmc.practice.strings.ReadCharsFromAString;
import com.bmc.practice.strings.ReadTextFile;
import com.bmc.practice.strings.RemoveWhiteSpaces;
import com.bmc.practice.strings.ReverseString;
import com.bmc.practice.strings.ReverseStringWithOutApi;
import com.bmc.practice.strings.SortCharacters;
import com.bmc.practice.strings.StringJoinerExamples;
import com.bmc.practice.strings.StringPadding;
import com.bmc.practice.test.java8.Lambda;

/**
 * Main Practice class
 *
 */
public class MyClass {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		ReverseString rev = new ReverseString();

		// reverse string using reccursion
		String reversedStr = rev.reverseStringRecursive("Reverse me");
		System.out.println("String reversed to: " + reversedStr);

		// reverse using string builder class
		rev.reverseUsingJavaFunc("how to reverse");

		// reverse words in a string.
		rev.reverseWordsOfStringUsingStringTokenizer(
				"Java technology blog for smart java concepts and coding practices");
		rev.reverseWordsOfStringUsingStringSplit("Java technology blog for smart java concepts and coding practices");
		rev.reverseEachWordsOfStringUsingSplit("how to reverse");

		// Removing white spaces.
		RemoveWhiteSpaces removeSpace = new RemoveWhiteSpaces();
		removeSpace.removeWhiteSpace("how to   do    in  java   .         com");
		removeSpace.removeWhiteSpaceUsingExpression("how to   do    in  java   .         com");
		removeSpace.removeLeadTrailSpace("   howtodoinjava.com   ");
		removeSpace.removeLeadSpacesUsingReplaceFirst("   howtodoinjava.com   ");
		removeSpace.removeLeadingSpaceUsingExpression("   howtodoinjava.com   ");
		removeSpace.removeLeadingSpacesUsingIsWhitespace("   howtodoinjava.com   ");
		removeSpace.removeTrailingSpaceUsingExpression("   howtodoinjava.com   ");
		removeSpace.removeTrailingSpacesUsingIsWhitespace("   howtodoinjava.com   ");

		// Find Duplicate
		FindDuplicate findDup = new FindDuplicate();
		findDup.findDuplicateWordsInString();
		findDup.findDuplicateCharacters();

		// Sorting
		SortCharacters sort = new SortCharacters();
		sort.sortStringUsingArraySort();

		// Read file
		ReadTextFile readFile = new ReadTextFile();
		readFile.readLineByLineJava8("C:\\temp\\mydebug.txt");
		readFile.readAllBytesJava7("C:\\temp\\mydebug.txt");
		readFile.usingBufferedReader("C:\\\\temp\\\\mydebug.txt");
		
		//String Joiner
		StringJoinerExamples strJoiner = new StringJoinerExamples();
		strJoiner.stringJoinerWithDelimAndSufFixPrefix();
		strJoiner.stringJoinerWithDelim();
		strJoiner.mergeStrings();
		strJoiner.collectorsJoining();
		
		//String Padding
		StringPadding strPad= new StringPadding();
		strPad.leftPaddingWithSpaceUsingStringUtils(); // Using StringUtils
		strPad.leftPaddingWithZeroUsingStringUtils(); // Using StringUtils
		strPad.rightPadding(); // Using StringUtils
		strPad.PaddingWithSpaceUsingStringFormat();//Using  String.format
		strPad.PaddingWithSpaceUsingLogic();    //Using programming Logic
		
		//Reading characters from a string.
		ReadCharsFromAString readChar = new ReadCharsFromAString();
		readChar.getFirstFewCharacter();
		readChar.getLastFewCharacter();
	
		//Palindrome
		Palindrome pal = new Palindrome();
		pal.findPalindromeStr("dalda");
		pal.findPalindromeStr("abababa");
		
		//Lambda
		Lambda lambda = new Lambda();
		lambda.lambdaFunctionExample();
		
	}
}
