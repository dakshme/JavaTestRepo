package com.bmc.practice.concurrentPackage;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

	public static void main(String[] args) {
		
		ReentrantLock l = new ReentrantLock();
		
		l.lock(); // executed by main thread, so main thread gets the lock
		l.lock(); // 2nd hold by main thread again
		
		System.out.println(l.isLocked()); //true
		System.out.println(l.isHeldByCurrentThread()); //true
		System.out.println(l.getQueueLength()); //0 , as no other thread is there
		System.out.println(l.getHoldCount()); // 2
		l.unlock();
		System.out.println(l.getHoldCount()); //1
		System.out.println(l.isLocked()); //true
		l.unlock();
		System.out.println(l.isLocked()); //false
		System.out.println(l.isFair()); // false
	}

}
