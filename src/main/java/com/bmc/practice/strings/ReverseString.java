package com.bmc.practice.strings;

import java.util.Stack;
import java.util.StringTokenizer;

public class ReverseString {

	// reverse string using recursion
	public String reverseStringRecursive(String str) {
		if (str.isEmpty())
			return str;

		// Calling function recursively
		return reverseStringRecursive(str.substring(1)) + str.charAt(0);
	}

	// reverse string using string builder
	public void reverseUsingJavaFunc(String str) {

		System.out.println("Using Java Func String reversed to: " + new StringBuilder(str).reverse());
	}

	// Reverse words in a string/sentence using string split function.
	public void reverseWordsOfStringUsingStringSplit(String str) {
		String[] splittedString = str.split(" ");
		StringBuilder reverseString = new StringBuilder();

		int len = splittedString.length;
		for (; len > 0; len--) {
			reverseString.append(splittedString[len - 1] + " "); // add one space as separator
		}
		System.out.println("String with words reversed is using split:[" + reverseString.toString() + "]");
	}

	// Reverse each words in place in a string/sentence using string split function.
	public void reverseEachWordsOfStringUsingSplit(String str) {
		String[] splittedString = str.split(" ");
		StringBuilder reverseString = new StringBuilder();

		for (String word : splittedString) {
			String reverseWord = new StringBuilder(word).reverse().toString();
			reverseString.append(reverseWord + " "); // add one space as separator
		}
		System.out.println("String with Each words reversed in place:[" + reverseString.toString() + "]");
	}

	// Reverse words in a string/sentence. Java Program to reverse string by words
	public void reverseWordsOfStringUsingStringTokenizer(String str) {
		// reverse string builder
		StringBuilder reverseString = new StringBuilder();

		// Put words from String in Stack
		Stack<String> myStack = new Stack<String>();

		StringTokenizer tokenizer = new StringTokenizer(str, " ");

		while (tokenizer.hasMoreTokens()) {
			myStack.push(tokenizer.nextToken());
		}

		// Pop each word from stack and append in builder
		while (!myStack.empty()) {
			reverseString.append(myStack.pop() + " ");
		}

		System.out.println("String with words reversed is:[" + reverseString.toString() + "]");
	}

}
