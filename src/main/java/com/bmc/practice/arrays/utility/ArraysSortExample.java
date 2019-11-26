package com.bmc.practice.arrays.utility;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSortExample {

	public static void main(String[] args) {
		int[] a = {10,5,20,11,6};
		
		System.out.println("primitive before sorting: "); 
		for (int i : a) 
			System.out.println(i); /*10
5
20
11
6*/
		
		Arrays.sort(a);
		System.out.println("primitive after sorting: ");
		for (int i : a) 
			System.out.println(i); /*5
6
10
11
20*/
		
		String[] s = {"A", "Z", "B"};
		System.out.println("Object array before sorting: ");
		for (String s1 : s) 
			System.out.println(s1); /*A
Z
B*/
		
		//default natural sorting
		Arrays.sort(s);
		System.out.println("Object array after sorting: ");
		for (String s1 : s) 
			System.out.println(s1); /*A
B
Z*/
		
		//customized sorting
		Arrays.sort(s, new MyComparator());
		System.out.println("Object array after customized sorting: ");
		for (String s1 : s) 
			System.out.println(s1); /*Z
B
A*/
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