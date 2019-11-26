package com.bmc.practice.serealization.serialVersionUID;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Sender {

	public static void main(String[] args) throws IOException {

		SerializableObject obj1 = new SerializableObject();
		obj1.i=888;
		obj1.j=999;
		System.out.println("Before serialization, i "+obj1.i+" j "+obj1.j);
		
		//customized serialize object with callback writeObject
		FileOutputStream fos = new FileOutputStream("C:\\temp\\test\\Serealize.dmp");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj1);
	}
}
