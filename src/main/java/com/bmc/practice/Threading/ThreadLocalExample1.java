package com.bmc.practice.Threading;

public class ThreadLocalExample1 {

	public static void main(String[] args) {
		CustomerThread t1 = new CustomerThread("TCS");
		CustomerThread t2 = new CustomerThread("HCL");
		CustomerThread t3 = new CustomerThread("CSI");
		CustomerThread t4 = new CustomerThread("BMC");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}


class CustomerThread extends Thread {
	
	static Integer custId = 0;
	private static ThreadLocal<Integer> tl = new ThreadLocal<Integer>() {
		public Integer initialValue() {
			return ++custId;
		}
	};
	
	//constructor
	public CustomerThread(String name) {
		super(name);
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName()+" Executing with customer id ["+tl.get()+"]");		
	}	
}