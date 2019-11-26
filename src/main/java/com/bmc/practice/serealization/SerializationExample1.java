package com.bmc.practice.serealization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * Example showing basic serialization concept. 
 * If we do not implements serializable class then we get runtime error. java.io.NotSerializableException
 */

public class SerializationExample1 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int i =10;
	private int j = 20; //making it transient will restrict saving into file.
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		SerializationExample1 obj1 = new SerializationExample1();
		System.out.println("Original Object i="+obj1.i+" j="+obj1.j);
		
		
		FileOutputStream fos = new FileOutputStream("C:\\temp\\test\\Serealize.dmp");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj1); //serialize object to file
		
		//now try to desirealize the same object back
		FileInputStream fis = new FileInputStream("C:\\temp\\test\\Serealize.dmp");
		ObjectInputStream ois = new ObjectInputStream(fis);
		SerializationExample1 obj2 = (SerializationExample1)ois.readObject();
		
		System.out.println("Object Read from file i="+obj2.i+" j="+obj2.j);
		
		oos.close();
		ois.close();
	}
}
