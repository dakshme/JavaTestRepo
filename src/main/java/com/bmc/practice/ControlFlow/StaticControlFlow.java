package com.bmc.practice.ControlFlow;

/*
 * Static flow is the one time activity happens only once.
 * 
 *  static control flow takes place in below step:
 *  1. Identification of static members (static variables, static functions,
 *     static blocks) from top to bottom.
 *     
 *  2. Execution of static variable assignments and static blocks from top to bottom.
 *  
 *  3. Execution of main method.
 *   
 *   Using static blocks we can also print on console with out main method.
 *   On static variable (here i and j) we can only perform indirect read and not direct read
 */

public class StaticControlFlow {

	//static variable
	static int i = 10;
	
	/* static block */
	static {
		staticFunc();
		System.out.println("First Static Block");
	}
	
	//main method
	public static void main (String[] args) {
		staticFunc();
		System.out.println("Main Method");
	}
	
	public static void staticFunc( ) {
		System.out.println(j);  //print static variable 'j'
	}
	
	//static block
	static {
		System.out.println("Second static block");
	}
	
	static int j = 20;
}
