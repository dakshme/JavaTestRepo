package com.bmc.practice.java8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorLambda {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		list.add(25);
		list.add(0);
		list.add(5);
		list.add(10);
		list.add(15);
		list.add(20);
		System.out.println(list);
		
		//Sort using comprator interface, using lambda expression
//		Comparator c = (I1, I2)->(I1<I2)?1:(I1>I2)?-1:0;

		Collections.sort(list, (I1, I2)->(I1<I2)?1:(I1>I2)?-1:0);
		System.out.println("Descending Order "+list);

	}

}
