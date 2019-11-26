package com.bmc.practice.java8.lambda;

import java.util.function.Predicate;

public class PredicateFunctionalInterface2 {

	
	public static void main(String[] args) {
		
		//predicates on list objects, need to traverse each object
		//in the list while applying predicate on them.
		int[] array = {0,5,10,15,20,25,30};
		
		Predicate<Integer> p1 = x -> x>10; //predicate to get number > 10
		Predicate<Integer> p2 = x -> x%2==0; //predicate to get even numbers
		
		System.out.println("In the list number greater than 10:");
		m1(p1, array);
		System.out.println("\nIn the list even numbers are:");
		m1(p2, array);
		System.out.println("\nApplying both predicates:");
		m1(p1.and(p2), array);
		System.out.println("");
		m1(p1.or(p2), array);
		System.out.println("");
		m1(p1.negate(), array);
		
		
		//predicate to list names starting with letter 'K' or 'k' from given string array
		String[] nameList = {"dd","khh","thtt","kav","Kaif","Jaif","Saif"};
		Predicate<String> filterName = name -> name.startsWith("K") || name.startsWith("k");
		System.out.println("\nNames starting with letter K: ");
		listNamesStartsWithK(filterName,nameList);
	}
	
	public static void m1(Predicate<Integer> p, int[] intArray) {
		
		for (int num : intArray) {
			
			if (p.test(num))
				System.out.print(num+" ");			
		}
	}
	
	
	public static void listNamesStartsWithK(Predicate<String> filterName, String[] nameList) {
		
		for (String name : nameList) {
			
			if (filterName.test(name))
				System.out.print(name+" ");			
		}
	}
}
