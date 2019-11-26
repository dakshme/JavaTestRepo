package com.bmc.practice.oops;

public class AbstractClassExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

abstract class AnyPerson {
	
	String name;
	int age;
	
	//parent class constructor
	AnyPerson(String name, int age) {
		this.name=name;
		this.age=age;
	}
}

class OneStudent extends AnyPerson  {

	int rollNo;
	int marks;
	
	OneStudent(String name, int age, int rollNo, int marks) {
		super(name, age); //call to parent cosntructor
		this.rollNo = rollNo;
		this.marks = marks;
	}
}

class OneTeacher extends AnyPerson  {

	int salary;
	String subject;
	
	OneTeacher(String name, int age, int salary, String sub) {
		super(name, age); //call to parent cosntructor
		this.salary = salary;
		this.subject = sub;
	}
}