package com.bmc.practice.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//stream example
public class StreamExample {
	
	public static void main (String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(5);
		list.add(10);
		list.add(15);
		list.add(20);
		System.out.println("Original list "+list);
		
		//to list even number using stream: filter to be used with predicate (boolean)
		List<Integer> evenList = list.stream().filter(I->I%2==0).collect(Collectors.toList()); 
		System.out.println("even List "+evenList);
		
		//to have another list with every element double of original list: map to be used with Funtion<T,R>(functioal interface)
		List<Integer> doubleList = list.stream().map(I->I*2).collect(Collectors.toList());
		System.out.println("Double list "+doubleList);
		
		//to have another list with every element incremented by 5 of original list: map to be used with Funtion<T,R>(functioal interface)
		List<Integer> incrementedList = list.stream().map(I->I+5).collect(Collectors.toList());
		System.out.println("Incremented List "+incrementedList);
		
		//to filter strings from array based on length like filter out odd length string
		ArrayList<String> strList = new ArrayList<>();
		strList.add("test me");
		strList.add("test him");
		strList.add("testing him");
		strList.add("tested him");
		strList.add("found ok");
		System.out.println(strList);
		List<String> filteredList = strList.stream().filter(s->s.length()%2==0).collect(Collectors.toList());
		System.out.println(filteredList); //print string with even length
		
		//convert all strings from lower to upper case
		List<String> upperCaseList = strList.stream().map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(upperCaseList); //print string with upper case list
	}	

}
