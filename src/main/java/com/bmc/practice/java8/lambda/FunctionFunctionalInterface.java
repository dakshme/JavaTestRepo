package com.bmc.practice.java8.lambda;

import java.util.ArrayList;
import java.util.function.Function;

//usage of Funtion Functional interface ( apply SAM method) to get the total salary of all emp
//apply method takes single argument and return one value

public class FunctionFunctionalInterface {

	
	public static void main(String[] args) {
		
		ArrayList<Employee> listEmp = new ArrayList<>();
		listEmp.add(new Employee("Binny", 1000));
		listEmp.add(new Employee("Cinny", 2000));
		listEmp.add(new Employee("Pinny", 3000));
		listEmp.add(new Employee("Tinny", 4000));
		listEmp.add(new Employee("Vinny", 5000));
		
		System.out.println(listEmp);
		
		//define Function Funtional interface
		Function<ArrayList<Employee>, Double> fun = list ->  {
				
				double totalSal = 0; 
				for (Employee emp: list) {
					totalSal = totalSal + emp.sal;
				}
				return totalSal;
		};
		
		System.out.println("Total Sal of employees is : "+fun.apply(listEmp));
		
	}
}

class Employee {
	
	String name;
	int sal;
	
	public Employee (String name, int sal) {
		
		this.name = name;
		this.sal = sal;		
	}
	
	@Override
	public String toString() {
		
		return name+":"+sal;
	}
	
	
}
