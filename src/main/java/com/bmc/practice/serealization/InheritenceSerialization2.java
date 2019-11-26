package com.bmc.practice.serealization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * Parent is non-serializable and child is serializable
 */

class Parent {
	
	int i=10;	
	//default constructor
	public Parent () {
		System.out.println("Parent constructor called");
	}
}

class Child extends Parent implements Serializable {
	
	int j =20;
	//default constructor
	public Child () {
		System.out.println("Child class constructor");
	}
}

public class InheritenceSerialization2 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Child obj1 = new Child();
		obj1.i = 888;
		obj1.j=999;
		System.out.println("Child obj1, i="+obj1.i+" j="+obj1.j);
		
		//serialize child object (implements Serializable interface)
		FileOutputStream fos = new FileOutputStream("C:\\temp\\test\\Serealize.dmp");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj1);
		
		//de-serialize child object now
		FileInputStream fis = new FileInputStream("C:\\temp\\test\\Serealize.dmp");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Child obj2 = (Child)ois.readObject();
		System.out.println("deserialize child l1, i="+obj2.i+" j="+obj2.j);
	}
}
