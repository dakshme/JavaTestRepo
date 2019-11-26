package com.bmc.practice.collections.utility;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsReverseUtil {

	public static void main(String[] args) {
		ArrayList<Integer> i = new ArrayList<>();
		
		i.add(45);
		i.add(10);
		i.add(20);
		i.add(70);
		i.add(90);
		i.add(5);
		
		System.out.println(i); //[45, 10, 20, 70, 90, 5]
		Collections.reverse(i);
		System.out.println("After revese: "+i); //After revese: [5, 90, 70, 20, 10, 45]
	}
}
