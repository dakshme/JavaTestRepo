package com.bmc.practice.constructor;


/*
 * Program to count the number of objects created for a class using instance block. Never do that using
 * constructor is its causes code redundancy and also not accurate as internally one constructor may call another.
 * 
 * Look the below program.
 */

public class ConstructorExample1 {
	
	static int count =0;
	//instance block
	{
		count++;
	}

	//constructor 1
	ConstructorExample1() {	}
	
	//constructor 2
	ConstructorExample1(int i) { }
	
	//constructor 3
	ConstructorExample1(double d) {	}
	
	//main program
	public static void main(String[] args) {
		
		ConstructorExample1 obj1 = new ConstructorExample1();
		ConstructorExample1 obj2 = new ConstructorExample1(10);
		ConstructorExample1 obj3 = new ConstructorExample1(10.5);
		System.out.println("Total object created are: "+count);
	}
}
