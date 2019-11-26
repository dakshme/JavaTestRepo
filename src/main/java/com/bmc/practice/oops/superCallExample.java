package com.bmc.practice.oops;

/*
 * This example to shown whenever we create child class the is implicit/explicit call goes to equivalent 
 *  parent class constructor too to initialize the inheriting member/instance variable.
 */

public class superCallExample {

	public static void main(String[] args) {
		
		Student s = new Student("Mahesh", 34, 100, 99);
	}
}

class Person {
	
	String name;
	int age;
	
	//parent class constructor
	Person(String name, int age) {
		this.name=name;
		this.age=age;
	}
}

class Student extends Person  {

	int rollNo;
	int marks;
	
	Student(String name, int age, int rollNo, int marks) {
		super(name, age); //call to parent cosntructor
		this.rollNo = rollNo;
		this.marks = marks;
	}
}