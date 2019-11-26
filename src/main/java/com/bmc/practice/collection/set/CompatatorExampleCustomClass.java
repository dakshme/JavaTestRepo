package com.bmc.practice.collection.set;

import java.util.Comparator;
import java.util.TreeSet;

public class CompatatorExampleCustomClass implements Comparator<Object> {

	public static void main(String[] args) {
		
		Employee e1 = new Employee("John", 100);
		Employee e2 = new Employee("Nick", 10);
		Employee e3 = new Employee("Asile", 50);
		Employee e4 = new Employee("Ram", 30);
		Employee e5 = new Employee("John", 100);  //duplicate
		
		// TreeSet having Employee object in natural sorting order (Comparable implementation)		
		TreeSet<Employee> t1 = new TreeSet<>();
		t1.add(e1);
		t1.add(e2);
		t1.add(e3);
		t1.add(e4);
		t1.add(e5);
		
		System.out.println("Natural  by eid \n"+t1); // [(Nick,10), (Ram,30), (Asile,50), (John,100)]
		
		// TreeSet having Employee object in custom sorting order (Comparator implementation)
		TreeSet<Employee> t2 = new TreeSet<>(new CompatatorExampleCustomClass());
		t2.add(e1);
		t2.add(e2);
		t2.add(e3);
		t2.add(e4);
		t2.add(e5);
		
		System.out.println("Custom order by Name \n"+t2); // [(Asile,50), (John,100), (Nick,10), (Ram,30)]


	}

	//Implement Comparator if we want sorting to be based on name and not on eid
	@Override
	public int compare(Object o1, Object o2) {
		
		Employee e1 = (Employee) o1;
		Employee e2 = (Employee) o2;
		
		return e1.getEname().compareTo(e2.getEname());
	}
}

class Employee implements Comparable<Employee> {

	private String ename;
	private int eid;
	
	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getEid() {
		return this.eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	//just like that kept private
	private Employee() {
		// Calling defalt contructor not allowed.
	}
	
	public Employee(String ename, int eid) {
		this.ename = ename;
		this.eid = eid;
	}
	
	@Override
	public String toString() {
		return "(" + ename + "," + eid + ")";
	}

	//default sorting order based on eid.
	@Override
	public int compareTo(Employee o) {
		
		if (this.eid > o.eid)
			return 1;
		else if (this.eid < o.eid)
			return -1;
		else
			return 0;
	}
}