package com.bmc.practice.Threading;


public class ThreadOddEvenPrint {

	
	public static void main(String[] args) {

		PrintOddEven t = new PrintOddEven();
		t.setName("Even Thread");
		t.start();
		
		while (t.i<t.number) {
			synchronized(t) {
				t.notify();
				System.out.println("Odd "+Thread.currentThread().getName() + " : " + ( ++t.i ));
				try {
					Thread.sleep( 500 );
					if( t.i != t.number ) 
						t.wait();
					} catch (InterruptedException e) {		e.printStackTrace();}
			}
		}
	}
}
	
 class PrintOddEven  extends Thread {
		int i =0;
		int number = 10;				
		
	public void run() {
			
		while (i<number) {
				
			//logic to print odd/even
			synchronized (this) {					
				notify();				
                System.out.println( Thread.currentThread().getName() + " : " + ( ++i ) );				
                try {
                    Thread.sleep( 500 );                    
                    if( i != number ) {
                         wait();
                    }
                } catch ( InterruptedException interruptedException ) {         interruptedException.printStackTrace();           }
			}
		}
	}
}
