package com.bmc.practice.strings;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortCharacters {
	
	// Sort string with Java 8 Stream API. Sorting the characters of string using
	// Stream.sorted() API
	public void sortStringWithStreamApi() {
		String randomString = "adcbgekhs";
		String sortedChars = Stream.of(randomString.split("")).sorted().collect(Collectors.joining());

		System.out.println(sortedChars);
	}

	// sort a string using Arrays.sort() method.
	public void sortStringUsingArraySort() {
		String randomString = "adcbgekhs";

		// Convert string to char array
		char[] chars = randomString.toCharArray();

		// Sort char array
		Arrays.sort(chars);

		// Convert char array to string
		String sortedString = String.valueOf(chars);

		System.out.println(sortedString); // abcdeghks
	}
}
