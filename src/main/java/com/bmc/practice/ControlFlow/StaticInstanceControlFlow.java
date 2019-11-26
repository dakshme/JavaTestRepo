package com.bmc.practice.ControlFlow;

/*
 * Its the mix of static and instance control flow. Below is the output:
 * 
 * First static block
   Second static block
   First instance block
   Second instance block
   Constructor
   Main Method
   First instance block
   Second instance block
   Constructor
 * 
 * In the above output instance control flow occurs twice as we saw creation of 2 objects.
 * But static control flow occurs only once.
 */

public class StaticInstanceControlFlow {
	
	//instance block
	{
		System.out.println("First instance block");
	}
	
	//static block
	static {
		System.out.println("First static block");		
	}
	
	//constructor
	StaticInstanceControlFlow() {
		System.out.println("Constructor");
	}
	
	//main method
	public static void main (String[] args) {
		StaticInstanceControlFlow t1 = new StaticInstanceControlFlow();
		System.out.println("Main Method");
		StaticInstanceControlFlow t2 = new StaticInstanceControlFlow();
	}
		
	//static block
	static {
		System.out.println("Second static block");		
	}
	
	//instance block
	{
		System.out.println("Second instance block");
	}
}
