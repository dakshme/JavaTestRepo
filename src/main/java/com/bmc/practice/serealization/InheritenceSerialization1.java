package com.bmc.practice.serealization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * Parent is serializable and child is non-serializable
 */

class Animal implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	int i =10;
}

class Lion extends Animal {
	
	private static final long serialVersionUID = 0L;
	int j = 20;
}

public class InheritenceSerialization1 {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		Lion l1 = new Lion();
		System.out.println("Lion l1, i="+l1.i+" j="+l1.j);
		
		//serialize object l1 of child class (though it does not implements Serializable interface)
		FileOutputStream fos = new FileOutputStream("C:\\temp\\test\\Serealize.dmp");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(l1);
		
		//de-serialize object l1 of child class (though it does not implements Serializable interface)
		FileInputStream fis = new FileInputStream("C:\\temp\\test\\Serealize.dmp");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Lion l2 = (Lion)ois.readObject();
		System.out.println("Lion l1, i="+l2.i+" j="+l2.j);
	}
}
