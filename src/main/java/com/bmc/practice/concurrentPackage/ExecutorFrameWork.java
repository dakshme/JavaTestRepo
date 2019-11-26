package com.bmc.practice.concurrentPackage;

/*
 * In the below example 3 Threads are responsible to execute 6 jobs. So that a single thread can be
 * reused for multiple jobs. 
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorFrameWork {

	public static void main(String[] args) {
		
		PrintJob[] jobs = { new PrintJob("Durga"),
							new PrintJob("Ravi"),
							new PrintJob("Shiva"),
							new PrintJob("Kiran"),
							new PrintJob("Suresh"),
							new PrintJob("Mahesh") };
		
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		for(PrintJob job : jobs) {
			service.submit(job);
		}
		service.shutdown();
	}
}

class PrintJob implements Runnable {

	String name;
	
	public PrintJob(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println(name+" Job started by Thread: "+Thread.currentThread().getName());
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) { }
		
		System.out.println(name+" Job COMPLETED by Thread "+Thread.currentThread().getName());
	}
}