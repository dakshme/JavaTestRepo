package com.bmc.practice.ControlFlow;
/*
 * Instance control flow takes place every time there is a creation of class object.
 * Instance variable only identified if we instantiate a class and not otherwise.
 * If we do not instantiate this class in main method then output will only be "Main Method".
 * 
 * Below is the instance control flow:
 * 1. This is followed by the static control from i.e. after main method below starts
 * 2. Identification of instance members from top to bottom.
 * 3. Execution of instance variable assignments and instance block from top to bottom.
 * 4. Execution of constructor 
 * 
 */

public class InstanceControlFlow {

	//instance variable
	int i = 10;
	
	//instance block
	{
		instanceFunc();
		System.out.println("First Instance block");
	}
	
	//Constructor
	InstanceControlFlow () {
		System.out.println("Constructor");
	}
	
	//main method
	public static void main (String[] args) {
		
		//As object is being created here so instance control flow starts here.
		InstanceControlFlow t = new InstanceControlFlow();
		System.out.println("Main Method");
		
		//System.out.println(i);  /* NOT allowed,non static field from static context. */
								  /* Also i is instance variable main can not use it without its object*/
	}
	
	public void instanceFunc() {
		System.out.println(j);
	}
	
	//instance block
	{
		System.out.println("Second Instance block");
	}
	
	int j = 20;
}

