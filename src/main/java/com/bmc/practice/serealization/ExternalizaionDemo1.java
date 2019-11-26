package com.bmc.practice.serealization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class ExternalClass implements Externalizable{
	
	String name; //serialize it
	int empNo;   //serialize it
	int sal;
	String depart;
	
	public ExternalClass() {
		System.out.println("ExternalClass default construcotr called");
	}
	
	public ExternalClass(String name, int empid, int sal, String dept) {
		this.name = name;
		this.empNo = empid;
		this.sal = sal;
		this.depart = dept;
	}
	
	public void writeExternal(ObjectOutput out) throws IOException {
		
		//serialize only required object and not whole object
		out.writeObject(name);
		out.writeInt(empNo);
	}
	
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		
		//de-serialize/read only required object from file
		name = (String) in.readObject();
		empNo = in.readInt();
	}
}

public class ExternalizaionDemo1 {

	public static void main(String[] args) throws ClassNotFoundException, IOException {

		ExternalClass obj1 = new ExternalClass("John", 1234, 5000, "Computers");
		System.out.println("Obj1 is "+obj1.name+" "+obj1.empNo+" "+obj1.sal+" "+obj1.depart);
		
		//serialize object now
		FileOutputStream fos = new FileOutputStream("C:\\temp\\test\\Serealize.dmp");
		ObjectOutputStream oos =  new ObjectOutputStream(fos);
		oos.writeObject(obj1);
		
		//de-serialize object now
		FileInputStream fis = new FileInputStream("C:\\temp\\test\\Serealize.dmp");
		ObjectInputStream ois =  new ObjectInputStream(fis);
		ExternalClass obj2 = (ExternalClass)ois.readObject();		
		
		System.out.println("After de-srialization Obj2 is "+obj2.name+" "+obj2.empNo+" "+obj2.sal+" "+obj2.depart);
	}
}
