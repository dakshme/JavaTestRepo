package com.bmc.practice.garbageCollector;

/*
 * Example to showing gc invocation automatically to claim unused object once gc realizes high usage of memory.
 */

public class GcFinalizeExample3 {

	static int count=0;
	public static void main(String[] args) {
		
		for(int i=0; i<800000; i++) {
			GcFinalizeExample3 dt = new GcFinalizeExample3();
			dt = null;
		}
		System.out.println("End of main");
	}

	public void finalize() {
		System.out.println("GC called finalize method on destroying Object "+ ++count);
	}

}
