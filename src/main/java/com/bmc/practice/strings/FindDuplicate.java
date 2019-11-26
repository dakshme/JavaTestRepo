package com.bmc.practice.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindDuplicate {

	
	public void findDuplicateWordsInString() {

		String str = "a r b k c d se f g a d f s s f d s ft gh f ws w f v x s g h d h j j k f sd j e wed a d f";

		// using Collections.frequency() to get duplicate words in string.

		List<String> list = Arrays.asList(str.split(" "));

		Set<String> uniqueWords = new HashSet<String>(list);
		for (String word : uniqueWords) {
			System.out.println(word + ": " + Collections.frequency(list, word));
		}
	}

	// Function to find duplicate characters in String
	public void findDuplicateCharacters() {
		String blogName = "howtodoinjava dot com";
		char[] chars = blogName.toCharArray();

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : chars) {
			if (map.containsKey(c)) {
				int counter = map.get(c);
				map.put(c, ++counter);
			} else
				map.put(c, 1);
		}

		System.out.println("Duplicate characters:");

		// Print duplicate characters
		for (char c : map.keySet()) {
			if (map.get(c) > 1) {
				System.out.println(c);
			}
		}

		System.out.println("Distinct characters:");

		// Print distinct characters
		for (char c : map.keySet()) {
			if (map.get(c) == 1) {
				System.out.println(c);
			}
		}
	}
}