package com.bmc.practice.concurrentPackage;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * Interface Callable is used to start a Thread in such a way that it will return an Object to its caller. 
 * 
 */

public class CallableThread {
	public static void main(String[] args) {
		
		MyCallable[] jobs = { new MyCallable(10),
							  new MyCallable(20),
							  new MyCallable(30),
							  new MyCallable(40),
							  new MyCallable(50),
							  new MyCallable(60)};
		
		ExecutorService service = Executors.newFixedThreadPool(3); 
		
		for(MyCallable job : jobs) {
		Future<Object> f = service.submit(job);
		try {
			System.out.println(f.get());
		} catch (InterruptedException e) {		} catch (ExecutionException e) {
			e.printStackTrace(); }
		}
		service.shutdown();
	}
}

class MyCallable implements Callable<Object> {

	int num;
	
	public MyCallable(int num) {
		this.num = num;
	}
	
	@Override
	public Object call() throws Exception {
		int sum=0;
		for (int i = 0; i<=num; i++) {
			sum = sum+i;
		}
		System.out.println("Job COMPLETED by Thread "+Thread.currentThread().getName()+" Sum Result is "+sum);
		return sum;
	}
}
