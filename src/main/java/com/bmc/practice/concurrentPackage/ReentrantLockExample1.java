package com.bmc.practice.concurrentPackage;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample1 {

	public static void main(String[] args) {
		
		Display d = new Display();
		MyTestThread t = new MyTestThread(d,"Mahesh");
		MyTestThread t1 = new MyTestThread(d,"Yukti");
		t.start();
		t1.start();
	}
}

class MyTestThread extends Thread{
	
	Display d;
	String name;
	
	MyTestThread(Display d, String name) {
		this.d = d;
		this.name = name;
	}
	
	public void run( ) {
		d.wish(name);
	}
}

class Display {
	
	ReentrantLock l = new ReentrantLock();
	
	public void wish(String name) {
		l.lock();
		for (int i=0; i<10; i++) {
			System.out.print("Good Monring ");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {e.printStackTrace();}
			System.out.println(name);
		}
		l.unlock();
	}
}
