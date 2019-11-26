package com.bmc.practice.concurrentPackage;

/*
 * Implementing traffic signal using cycling barrier
 */

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class CyclicBarrierExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		//3 threads are part of the barrier, ServiceOne, ServiceTwo and this main thread calling them.
		Runnable barrier1Action = new Runnable() {
		    public void run() {
		        System.out.println(Thread.currentThread().getName()+" Barrier Action executed ");
		    }
		};
		
		final CyclicBarrier barrier = new CyclicBarrier(4, barrier1Action);
		
		ExecutorService service = Executors.newFixedThreadPool(3); 
		
		SignalService[] jobs = { new SignalService(barrier, "Left Signal"),
				  				 new SignalService(barrier, "Right Signal"),
				  				 new SignalService(barrier, "Forward Signal")};
		
		int signalRunTime=5;
		int count=0;
		Integer leftData=0, rightData=0, forwardData=0;
		
		// FutureTask is a concrete class that implements both Runnable and Future 
	    FutureTask[] signalTasks = new FutureTask[jobs.length]; 

		while(count<signalRunTime) {
			int task=0;
			for(SignalService job : jobs) {
				signalTasks[task] = (FutureTask) service.submit(job);
				++task;
			}
			
			try {
			    barrier.await();
			    leftData=(Integer) signalTasks[0].get();
			    rightData=(Integer) signalTasks[1].get();
			    forwardData=(Integer) signalTasks[2].get();
			    
			} catch (InterruptedException | BrokenBarrierException e) {
			    System.out.println("Main Thread interrupted!");
			    e.printStackTrace();
			}
			
			System.out.println("Got traffic Data from all signals, analysing......left "+leftData+" right "+rightData+" forward "+forwardData);
			
			if(leftData>rightData && leftData>forwardData)
				System.out.println("LEFT GREEN SIGNAL, GO....");
			else if(rightData>leftData && rightData>forwardData)
				System.out.println("RIGHT GREEN SIGNAL, GO....");
			else
				System.out.println("FORWARD GREEN SIGNAL, GO....");
			
			System.out.println("*****************************");
			System.out.println("Analysing next Iteration");
			Thread.sleep(5000);
			barrier.reset();	//rest barrier for next scheduling thread jobs		
			count++;
		}
		service.shutdown();
	}
}
	
class SignalService implements Callable<Integer> {
	
	private final CyclicBarrier cyclicBarrier;
	Random rand = new Random(); 
	String name;
	
	public SignalService(CyclicBarrier barrier, String name) {
		cyclicBarrier = barrier;
		this.name=name;
	}
	
	public Integer call() throws Exception {

			Thread.currentThread().setName(name);
			System.out.println("Starting "+Thread.currentThread().getName()+" signal service. Processing Traffic data");
			
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName()+" Number waiting "+cyclicBarrier.getNumberWaiting()+" Parties "+cyclicBarrier.getParties());
			cyclicBarrier.await();
			System.out.println(Thread.currentThread().getName()+" Number waiting "+cyclicBarrier.getNumberWaiting()+" Parties "+cyclicBarrier.getParties());
			return rand.nextInt(20);
	}
}
