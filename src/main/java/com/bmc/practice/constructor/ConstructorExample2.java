package com.bmc.practice.constructor;

/*
 * Methods with same name as class is valid but wrong programming practice.
 */
public class ConstructorExample2 {
	
	/* Its a method and NOT a constructor as it has return type */
	void ConstructorExample2 ( ) {
		System.out.println("Its a method and NOT a constructor");
	}

	public static void main (String[] args) {
		ConstructorExample2 obj = new ConstructorExample2();
		obj.ConstructorExample2();
	}
	
}
