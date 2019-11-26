package com.bmc.practice.collections.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionsCustomSort {

	public static void main(String[] args) {
		ArrayList< String> al = new ArrayList<>();
		al.add("B");
		al.add("A");
		al.add("Z");
		al.add("F");		
		//al.add(null); // this will cause NPE while calling Collections.sort() as null not allowed while comparing
		
		System.out.println("Before Sorting: "+al); //Before Sorting: [B, A, Z, F]
		Collections.sort(al, new MyComparator());
		System.out.println("After Sorting: "+al); //After Sorting: [Z, F, B, A]

	}

}

class MyComparator implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		
		String s1 = o1.toString();
		String s2 = o2.toString();
		return s2.compareTo(s1); //descending order sorting
	}	
}

