package com.bmc.practice.test.java8;

import java.util.ArrayList;
import java.util.List;

public class Lambda {

	public void lambdaFunctionExample() {

		List<Integer> numList = new ArrayList<Integer>();

	    numList.add(10);
	    numList.add(20);
	    numList.add(30);
	    numList.add(40);

	    //foreach loop with lambda
	    numList.forEach( item -> System.out.println(item) );

        //Another way Pass function reference
        numList.forEach( System.out::println );
	}
	
}
