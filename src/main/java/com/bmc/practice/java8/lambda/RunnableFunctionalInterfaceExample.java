package com.bmc.practice.java8.lambda;

//THIS IMPLEMENTING Runnable interface is ALSO NOT required
//class MyRunnable implements Runnable {
//
//	@Override
//	public void run() {
//		for (int i = 0; i<10; i++) {
//			System.out.println("child thread");
//		}	
//	}
//
//}

public class RunnableFunctionalInterfaceExample {

	public static void main(String[] args) {

		//NORMAL and usual way of running a runnable task
//		Thread th = new Thread(new MyRunnable());
//		th.start();

		//using lambda expression way
		Runnable rn = () -> {
			for (int i = 0; i<5; i++) {
				System.out.println("child thread with lambda");
			}
		};
		Thread th = new Thread(rn); //rn is the runnable object already defined using lambda expression
		th.start();		//process of starting a thread remains same both the cases
		
		for (int i = 0; i<5; i++) {
			System.out.println("Parent thread");
		}
	}

}
