package com.bmc.practice.concurrentPackage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantTryLock {

	public static void main(String[] args) {
		MyThread t = new MyThread("First Thread");
		MyThread t1 = new MyThread("Second Thread");
		
		t.start();
		t1.start();
	}

}

class MyThread extends Thread{
	
	static ReentrantLock l = new ReentrantLock();
	
	MyThread( String name) {
		super(name);
	}
	
	public void run( ) {
		
		try {
			if(l.tryLock(3000, TimeUnit.MILLISECONDS)) {
				System.out.println(Thread.currentThread().getName()+" Got the lock now perforning safe operations");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) { 	e.printStackTrace(); 	}
				l.unlock(); //  unlock the lock
			}
			else {
				System.out.println(Thread.currentThread().getName()+" Didnt not get the lock. Continue with the alternate operation");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}