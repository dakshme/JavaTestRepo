package com.bmc.practice.Thread.ThreadGroup;

public class ThreadGroupExample2 {

	public static void main(String[] args) {
		//Create 2 thread group
		ThreadGroup pg = new ThreadGroup("Parent Group"); // Thread Group
		ThreadGroup cg = new ThreadGroup(pg, "Child Group"); // sub thread group
		
		//add threads to group
		MyTestThread t1 = new MyTestThread(pg, "Child Thread 1"); //2
		MyTestThread t2 = new MyTestThread(pg, "Child Thread 2"); //1
		t1.start();
		t2.start();
		
		System.out.println(pg.activeCount()); //0
		System.out.println(pg.activeGroupCount()); //1
		pg.list();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(pg.activeCount());
		System.out.println(pg.activeGroupCount());
		pg.list();	
	}
}

class MyTestThread extends Thread {
	
	//need this constructor as we need to set group name also
	public MyTestThread(ThreadGroup g, String name) {
		super(g, name);		
	}
	
	public void run() {
		System.out.println("child thread ");
		try {
			Thread.sleep(4000);  // 4sec sleep
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
}
