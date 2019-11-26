package com.bmc.practice.strings;

import org.apache.commons.lang3.StringUtils;

public class RemoveWhiteSpaces {

	// Using StringUtils
	public void removeWhiteSpace(String str) {

		System.out.println("Using String utils :" + StringUtils.normalizeSpace(str));
	}

	// Using regular expression from within string
	public void removeWhiteSpaceUsingExpression(String str) {
		System.out.println("Using regular expression :" + str.replaceAll("\\s+", ""));
	}

	// to remove leading white spaces with regular expression
	public void removeLeadingSpaceUsingExpression(String str) {
		String regex = "^\\s+"; // from front only
		System.out
				.println("Remove leading Using replaceAll & regular expression : [" + str.replaceAll(regex, "") + "]");
	}

	// to remove only trailing spaces with regular expression
	public void removeTrailingSpaceUsingExpression(String str) {
		String regex = "\\s+$"; // from front only
		System.out
				.println("Remove trailing Using replaceAll & regular expression : [" + str.replaceAll(regex, "") + "]");
	}

	// Remove trailing white spaces using Character.isWhitespace()
	public void removeTrailingSpacesUsingIsWhitespace(String param) {
		if (param == null)
			System.out.println("input string null");

		int len = param.length();
		for (; len > 0; len--) {
			if (!Character.isWhitespace(param.charAt(len - 1)))
				break;
		}
		System.out.println("remove trailing spaces Using isWhitespace :[" + param.substring(0, len) + "]");
	}

	// to remove the leading and trailing spaces using String.trim() method.
	public void removeLeadTrailSpace(String str1) {
		System.out.println("using String.trim method: " + str1.trim());
	}

	// Remove leading using String.replaceFirst() function
	public void removeLeadSpacesUsingReplaceFirst(String str) {
		String regex = "\\s+"; // remove spaces from front side
		System.out.println("Remove leading spaces Using replaceFirst & regular expression : ["
				+ str.replaceFirst(regex, "") + "]");
	}

	// Remove leading white spaces using Character.isWhitespace()
	public void removeLeadingSpacesUsingIsWhitespace(String str) {

		if (str == null)
			System.out.println("null received");
		;

		if (str.isEmpty())
			System.out.println("Empty String received");
		;

		int arrayIndex = 0;
		while (true) {
			if (!Character.isWhitespace(str.charAt(arrayIndex++))) {
				break;
			}
		}

		System.out.println("remove leading spaces Using isWhitespace : [" + str.substring(arrayIndex - 1) + "]");
	}
}
