package com.bmc.practice.java8;

//default method in interface to show diamond problem

interface int1 {

	default void show () {
		System.out.println("Show of Int 1");
	}	
}

interface int2 {

	default void show () {
		System.out.println("Show of Int 2");
	}	
}

public class DefaultInterface implements int1, int2{

	public static void main(String[] args) {
		
		DefaultInterface obj = new DefaultInterface();
		obj.show();

	}

	@Override
	public void show() {

		int1.super.show(); //OR give some new definition like below
		System.out.println("override it ");
	}
}
