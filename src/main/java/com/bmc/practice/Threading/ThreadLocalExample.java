package com.bmc.practice.Threading;

/*
 * ThreadLocal objects value is always associated with specific Threads.
 * ThreadLocal class provides thread local variables. ThreadLocal class maintains values per thread basis.
 * Each ThreadLocal object maintains a separate value
 */

public class ThreadLocalExample {

	public static void main(String[] args) {
		ThreadLocal<String> tl = new ThreadLocal<String>()
		{
			//inner annonymous class to override initialValue() method
			public String initialValue() {
				return "abcd";				
			}
		};
		System.out.println(tl.get()); // abcd
		tl.set("John");
		System.out.println(tl.get()); // John
		tl.remove();
		System.out.println(tl.get()); // null

	}

}
