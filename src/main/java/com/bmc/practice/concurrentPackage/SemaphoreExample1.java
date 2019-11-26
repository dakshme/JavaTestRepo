package com.bmc.practice.concurrentPackage;

import java.util.concurrent.Semaphore;

public class SemaphoreExample1 {

	public static void main(String[] args) {
		
		Show d = new Show();
		MyThread1 t = new MyThread1(d,"John");
		MyThread1 t1 = new MyThread1(d,"Janarthan");
		t.start();
		t1.start();
	}
}

class MyThread1 extends Thread{
	
	Show print;
	String name;
	
	MyThread1(Show print, String name) {
		this.print = print;
		this.name = name;
	}
	
	public void run( ) {
		print.wish(name);
	}
}

class Show {
	
	//Only 1 thread allowed
	Semaphore sem = new Semaphore(1);
	
	public void wish(String name) {
		
		try {
			sem.acquire();
		} catch (InterruptedException e1) { e1.printStackTrace(); 	}
		
		for (int i=0; i<5; i++) {
			System.out.print("Good Monring ");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {e.printStackTrace();}
			System.out.println(name);
		}
		sem.release();
	}
}
