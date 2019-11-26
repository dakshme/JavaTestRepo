package com.bmc.practice.garbageCollector;

/*
 * finalize() example.
 * while destroying an object gc calls the finalize method of the corresponding class.
 */

public class GcFinalizeExample {

	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		
		String s = new String("Mahesh");
		s=null;	//finalize of class String will be called and not gcFinalizeExample
		
		GcFinalizeExample g = new GcFinalizeExample();
		GcFinalizeExample g1 = new GcFinalizeExample();
		g=null;	//finalize of class gcFinalizeExample will be called if overridden
		g1=null;	//finalize of class gcFinalizeExample will be called if overridden
		
		r.gc(); // from this point onward gc daemon thread will also come in picture along with main thread.
		
		System.out.println("End of main");
	}
	
	public void finalize() {
		System.out.println("GC called finalize method on destroying Object");
	}
}
