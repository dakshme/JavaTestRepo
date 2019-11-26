package com.bmc.practice.collections.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionsBinarySearch {

	public static void main(String[] args) {
		ArrayList< Integer> al = new ArrayList<>();
		al.add(10);
		al.add(5);
		al.add(50);
		al.add(17);
		al.add(60);
		
		System.out.println("Before Sorting: "+al); //Before Sorting: [10, 5, 50, 17, 60]
		Collections.sort(al, new MyComparator1());
		System.out.println("After Sorting: "+al); // After Sorting: [60, 50, 17, 10, 5]
		
		System.out.println(Collections.binarySearch(al, 10, new MyComparator1())); //3
		System.out.println(Collections.binarySearch(al, 60, new MyComparator1())); //0
		System.out.println(Collections.binarySearch(al, 56, new MyComparator1())); //-2
	}
}

class MyComparator1 implements Comparator<Integer> {
	@Override
	public int compare(Integer i1, Integer i2) {
		return i2.compareTo(i1); //descending order sorting
	}
}