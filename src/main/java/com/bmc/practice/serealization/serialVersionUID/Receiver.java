package com.bmc.practice.serealization.serialVersionUID;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Receiver {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		//customized deserialized object with callback readObject
		FileInputStream fis = new FileInputStream("C:\\temp\\test\\Serealize.dmp");
		ObjectInputStream ois = new ObjectInputStream(fis);
		SerializableObject obj2 = (SerializableObject) ois.readObject();
		
		System.out.println("After serialization, i "+obj2.i+" j "+obj2.j);
	}
}
