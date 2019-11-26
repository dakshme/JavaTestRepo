package com.bmc.practice.garbageCollector;

/*
 * Example of calling finalize method explicitly like a normal method.
 * This will not destroy the object.
 */

public class GcFinalizeExample1 {

	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		
		GcFinalizeExample1 g = new GcFinalizeExample1();
		
		g.finalize(); // its just like normal method call to finalize()
		g.finalize(); // its just like normal method call to finalize()
		
		g=null;	//finalize of class gcFinalizeExample will be called if overridden
		
		r.gc(); // from this point onward gc daemon thread will also come in picture along with main thread.
		
		System.out.println("End of main");
	}
	
	public void finalize() {
		System.out.println("GC called finalize method on destroying Object");
	}
	
}
