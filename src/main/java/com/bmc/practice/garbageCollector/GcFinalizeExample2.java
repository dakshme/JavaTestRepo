package com.bmc.practice.garbageCollector;

/*
 * In this example we see that finalize method only called once for any non referred object.
 * If GC has marked any object for sweep and finally while execution is in finalize and with in it same object gets 
 * the reference again then GC will not clean up it. Next time when it sees no active reference to same object it will
 * directly sweep the object without calling finalize() method once again.
 * 
 */

public class GcFinalizeExample2 {
	
	static GcFinalizeExample2 gg;
	
	public static void main(String[] args) {
		
		GcFinalizeExample2 g = new GcFinalizeExample2();
		
		System.out.println("object hashcode to ref g is "+g.hashCode());
	
		g=null;	//finalize of class gcFinalizeExample will be called if overridden		
		System.gc(); //first time call to finalize
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {		e.printStackTrace(); 		}

		
		System.out.println("object hashcode after finalize() call to ref gg is "+gg.hashCode());
		gg=null;		
		System.gc(); //again call to gc. This time no call made to finalize.
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {		e.printStackTrace(); 		}
		
		System.out.println("End of main with out calling finalize this time");
	}
	
	public void finalize() {
		System.out.println("Calling finalize method first time now");
		gg=this;
	}

}
