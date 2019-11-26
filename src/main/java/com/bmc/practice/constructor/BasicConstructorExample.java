package com.bmc.practice.constructor;

/* NOTE:
 * The main purpose of Constructor is to perform initialization of an object but not to create object.
 * Constructor is the best and simple way to init any object.
 * Other ways include instance block, or explicitly assigning values to instance variable using '.' (dot) operator
 * 
 */

public class BasicConstructorExample {
	
	//instance variables default values will be set while object creation i.e. null and 0 respectively.
	String name;
	int rollNo;
	
	public BasicConstructorExample () {
	}
	
	public BasicConstructorExample (String name, int rollNo) {
		this.name = name;
		this.rollNo = rollNo;				
	}
	
	public static void main (String[] args) {
		BasicConstructorExample obj1 = new BasicConstructorExample("Mahesh", 5);
		BasicConstructorExample obj2 = new BasicConstructorExample("John", 50);
		
		//explicit init, not good
		BasicConstructorExample obj3 = new BasicConstructorExample();
		obj3.name="Macsy";
		obj3.rollNo=40;
	}

}
