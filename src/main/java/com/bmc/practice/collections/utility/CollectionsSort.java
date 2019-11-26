package com.bmc.practice.collections.utility;

/*
 * Using Collections utility sorting based on default narutal sorting order. 
 */

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsSort {

	public static void main(String[] args) {
		ArrayList< String> al = new ArrayList<>();
		al.add("Z");
		al.add("F");
		al.add("B");
		al.add("A");
		//al.add(null); // this will cause NPE while calling Collections.sort() as null not allowed while comparing
		
		System.out.println("Before Sorting: "+al); //Before Sorting: [Z, F, B, A]
		Collections.sort(al);
		System.out.println("After Sorting: "+al); //After Sorting: [A, B, F, Z]
	}
}
