package com.bmc.practice.generics;

class Gen<T> {
	
	T obj;
	
	Gen(T obj) {
		this.obj = obj;
	}
	
	public void show () {
		System.out.println("this type of object is "+obj.getClass().getName());
	}
	
	public T getObj( ) {
		return obj;
	}
}


public class GenericClassExample {

	public static void main(String[] args) {

		//for String
		Gen<String> g1 = new Gen<String>("Mack");
		g1.show();  //this type of object is java.lang.String
		System.out.println(g1.getObj()); //Mack
		
		//for integer
		Gen<Integer> g2 = new Gen<Integer>(10);
		g2.show();   // this type of object is java.lang.Integer
		System.out.println(g2.getObj());  //10
		
		//for double
		Gen<Double> g3 = new Gen<Double>(10.5);
		g3.show();  // this type of object is java.lang.Double
		System.out.println(g3.getObj());  //10.5
	}
}
