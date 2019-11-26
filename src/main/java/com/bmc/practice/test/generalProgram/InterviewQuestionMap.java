package com.bmc.practice.test.generalProgram;

import java.util.HashMap;
import java.util.Map;

public class InterviewQuestionMap {

	public static void main(String[] args) {
		
		Map<Integer,String> map1 = new HashMap<Integer,String>();
		
		Integer i = new Integer(5);
		Integer ii = new Integer(5);		
		map1.put(i,	"one");
		map1.put(ii,	"one");
		System.out.println("size of map1 "+ map1.size() +" "+ i.equals(ii));
		System.out.println("i hashcode "+i.hashCode()+" "+" ii hashcode "+ii.hashCode());

		
		Map<Employee,String> map2 = new HashMap<Employee,String>();
		Employee e1 = new Employee("jack");
		Employee e2 = new Employee("jack");
		map2.put(e1, "jack");
		map2.put(e2, "jack");
		System.out.println("size of map2 "+ map2.size() +" "+ e1.equals(e2));
		System.out.println("e1 hashcode "+e1.hashCode()+" "+" e2 hashcode "+e2.hashCode());
		
		String str = new String("jack");
		String str1 = new String( "jack");
		System.out.println("str hashcode "+str.hashCode()+" "+" str1 hashcode "+str1.hashCode());

	}

}

class Employee {
	
	String name;
	
	public Employee(String name) {
		this.name = name;
	}
}
