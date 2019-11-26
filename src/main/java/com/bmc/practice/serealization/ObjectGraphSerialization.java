package com.bmc.practice.serealization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Dog implements Serializable{
	 
	private static final long serialVersionUID = 1L;
	Cat c = new Cat();
}

class Cat  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	Rat r = new Rat();
}

class Rat  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	int i = 10;
}

public class ObjectGraphSerialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Dog d1 = new Dog();
		
		FileOutputStream fos = new FileOutputStream("C:\\temp\\test\\Serealize.dmp");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(d1);
		
		FileInputStream fis = new FileInputStream("C:\\temp\\test\\Serealize.dmp");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Dog d2 = (Dog)ois.readObject();
		System.out.println("Value "+d2.c.r.i);
	}
}
