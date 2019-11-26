package com.bmc.practice.serealization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	String userId = "maheshdaksha";
	transient String password = "password"; //not to serialize it
	
	//call back method for serializing an object
	private void writeObject(ObjectOutputStream oos) throws Exception {
		
		//defult method to serialize normal instance variable
		oos.defaultWriteObject();
		//encrypt transient password field to string object and serialize it to file
		String encryptPassword = "123"+password;
		oos.writeObject(encryptPassword);		
	}
	
	//call back method for deserializing an object
	private void readObject(ObjectInputStream ois) throws Exception {
		
		//defult method to de-serialize normal instance variable
		ois.defaultReadObject();
		String decPassword = (String) ois.readObject(); //Now  encrypted password written post account object
		//now decrypt and assign to object password filed back 
		password = decPassword.substring(3); 
	}	
}

public class CustomizedSerialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Account obj1 = new Account();
		System.out.println("Before serialization, username "+obj1.userId+" Password "+obj1.password);
		
		//customized serialize object with callback writeObject
		FileOutputStream fos = new FileOutputStream("C:\\temp\\test\\Serealize.dmp");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj1);
		
		//customized deserialized object with callback readObject
		FileInputStream fis = new FileInputStream("C:\\temp\\test\\Serealize.dmp");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Account obj2 = (Account) ois.readObject();
		
		System.out.println("After serialization, username "+obj2.userId+" Password "+obj2.password);
	}
}
