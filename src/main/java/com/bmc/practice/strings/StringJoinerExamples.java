package com.bmc.practice.strings;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringJoinerExamples {

	//StringJoiner with delimiter
	public void stringJoinerWithDelim() {
		
		StringJoiner joiner = new StringJoiner("-");
        
		joiner.add("how");
		joiner.add("to");
		joiner.add("do");
		joiner.add("in");
		joiner.add("java");
		 
		String result = joiner.toString();
		 
		System.out.println(result); //how-to-do-in-java
	}
	
	//StringJoiner with delimiter and suffix, prefix	
	public void stringJoinerWithDelimAndSufFixPrefix() {
		
		StringJoiner joiner = new StringJoiner(",", "[", "]");
        
		joiner.add("how");
		joiner.add("to");
		joiner.add("do");
		joiner.add("in");
		joiner.add("java");
		 
		String result = joiner.toString();
		 
		System.out.println(result); //[how,to,do,in,java]
	}
	
	//StringJoiner merge
	public void mergeStrings() {
		//First Joiner
		StringJoiner joiner1 = new StringJoiner(",", "[", "]");
		         
		joiner1.add("how");
		joiner1.add("to");
		joiner1.add("do");
		joiner1.add("in");
		joiner1.add("java");
		 
		//Second Joiner
		StringJoiner joiner2 = new StringJoiner("-", "{", "}");
		 
		joiner2.add("java");
		joiner2.add("tutorials");
		joiner2.add("blog");
		
		joiner1.merge( joiner2 );
		 
		System.out.println( joiner1.toString() );   //Merged content O/P=[how,to,do,in,java,java-tutorials-blog]		 
		System.out.println( joiner2.toString() );   //Unchanged O/P= {java-tutorials-blog}		
	}
	
	//Java 8 Stream – Collectors.joining()
	public void collectorsJoining() {
		
		//Join stream of string values
		List<String> blogNameParts = Arrays.asList("how", "to", "do", "in", "java");
        
		String joinedString = blogNameParts.stream()
		                                .map(namePart -> namePart)
		                                .collect(Collectors.joining(",", "[", "]"));		 
		System.out.println(joinedString); // O/P= [how,to,do,in,java]
		
		//join stream of integers
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        
		String joinedStringOfInt = numbers.stream()
		                            .map(number -> String.valueOf(number))
		                            .collect(Collectors.joining(","));		 
		System.out.println(joinedStringOfInt); // O/P= 1,2,3,4,5,6,7,8,9
		
	}	
}
