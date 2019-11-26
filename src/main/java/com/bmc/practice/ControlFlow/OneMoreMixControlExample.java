package com.bmc.practice.ControlFlow;

public class OneMoreMixControlExample {
	
	//instance member
	private static String  m1(String msg) {
		System.out.println(msg);
		return msg;
	}
	
	//constructor
	public OneMoreMixControlExample( ) {
		String m = m1("1");
	}
	
	//instance block
	{
		String m = m1("2");
	}
	
	//instance variable
	String m = m1("3");
	
	//main method
	public static void main (String[] args) {
		//instance creation
		Object o = new OneMoreMixControlExample();
		System.out.println("main over");
	}

}
