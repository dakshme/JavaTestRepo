package com.bmc.practice.serealization;

/*
 * Customized serialization with multiple transient fields.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class PrivateAccount implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	String userId = "maheshdaksha";
	transient String password = "password"; //not to serialize it
	transient int pin = 1234; //not to serialze

	//call back method for serializing an object
	private void writeObject(ObjectOutputStream oos) throws Exception {
		
		//default method to serialize normal instance variable
		oos.defaultWriteObject();
		//encrypt transient password field to string object and serialize it to file
		String encryptPassword = "123"+password;
		oos.writeObject(encryptPassword);
		
		//encypt pin and store
		int ipin = 4444+pin;
		oos.writeInt(ipin);
	}
	
	//call back method for deserializing an object
	private void readObject(ObjectInputStream ois) throws Exception {
		
		//defult method to de-serialize normal instance variable
		ois.defaultReadObject();
		String decPassword = (String) ois.readObject(); //Now  encrypted password written post account object
		//now decrypt and assign to object password filed back 
		password = decPassword.substring(3); 
		
		//not decypt pin also
		pin =  (int) ois.readInt() - 4444;
	}	
}


public class CustomizedSerialization2 {

public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		PrivateAccount obj1 = new PrivateAccount();
		System.out.println("Before serialization, username "+obj1.userId+" Password "+obj1.password+" pin "+obj1.pin);
		
		//customized serialize object with callback writeObject
		FileOutputStream fos = new FileOutputStream("C:\\temp\\test\\Serealize.dmp");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj1);
		
		//customized deserialized object with callback readObject
		FileInputStream fis = new FileInputStream("C:\\temp\\test\\Serealize.dmp");
		ObjectInputStream ois = new ObjectInputStream(fis);
		PrivateAccount obj2 = (PrivateAccount) ois.readObject();
		
		System.out.println("After serialization, username "+obj2.userId+" Password "+obj2.password+" pin "+obj2.pin);
	}

}
