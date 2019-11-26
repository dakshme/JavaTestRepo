package com.bmc.practice.java8.lambda;

import java.util.TreeSet;

public class TreeSetLambda {

	public static void main(String[] args) {

		//Comparator Functional interface lambda is specified to sort by descending order.
		//Otherwise default is ascending order
		TreeSet<Integer> ts = new TreeSet<>((I1, I2)->(I1<I2)?1:(I1>I2)?-1:0);

		ts.add(20);
		ts.add(3);
		ts.add(87);
		ts.add(11);
		ts.add(55);
		ts.add(1);
		
		System.out.println(ts);
	}

}
