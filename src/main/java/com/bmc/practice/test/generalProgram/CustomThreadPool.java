package com.bmc.practice.test.generalProgram;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//program to design our own thread pool

public class CustomThreadPool {

	public static void main(String[] args) {
		
		//create queue size - 3 and Number of threads - 4
        ThreadPool threadPool = new ThreadPool(3, 4);
        
        //Created 7 Tasks and submit to pool
        for(int taskNumber = 1 ; taskNumber <= 7; taskNumber++) {
        	
        	TaskToBePerformedByThread task = new TaskToBePerformedByThread("Task Name "+taskNumber);
            try {
				threadPool.submitTask(task);
			} catch (InterruptedException e) { e.printStackTrace(); }
        }
	}
}

//class to create thread pool submit task to pool
class ThreadPool {
	
    BlockingQueue <Runnable> queue;
    
    public ThreadPool(int queueSize, int nThread) {
    	
        queue = new ArrayBlockingQueue<Runnable>(queueSize);
        
        String threadName = null;
        
        //runnable lambda expression
        //The method of dequeue the task from the queue (BlockingQueue) and executes its run method
        Runnable r = () -> {        	
        	try {
                while (true) {
                    String name = Thread.currentThread().getName();
                  //get task from queue and block if queue is empty
                    Runnable task = queue.take();
                    System.out.println("Task Started by Thread :" + name);
                    task.run();
                    System.out.println("Task Finished by Thread :" + name);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        	
        };
        
        //create 4 threads in the custom thread pool
        for (int count = 0; count < nThread; count++) {
        	threadName = "Thread-"+count;
            Thread thread = new Thread(r, threadName);
            thread.start();
        }
    }

    public void submitTask(Runnable task) throws InterruptedException {
        //put to queue and block if no space is available
    	queue.put(task);
    }
}


//TaskToBePerformedByThread simulates the task to be submitted to thread pool.
class TaskToBePerformedByThread implements Runnable {
	
    private String taskName;
    public TaskToBePerformedByThread(String taskName) {
        this.taskName = taskName;
    }
   
    @Override
    public void run() {
        System.out.println("Start executing of task number by one thread among pool  :"+ taskName);
        try {
            //Simulating processing time
        	//perform tasks
            Thread.sleep(1000);
        } catch (InterruptedException e) {	
            e.printStackTrace();
        }
        System.out.println("End executing of task number :"+ taskName);
    }
}

