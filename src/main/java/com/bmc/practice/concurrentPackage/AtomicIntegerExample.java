package com.bmc.practice.concurrentPackage;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {

	public static void main(String[] args) {
		
		AtomicInteger intVal = new AtomicInteger(0);		
		System.out.println(intVal.getAndAdd(10)); // 0
		System.out.println(intVal.addAndGet(10)); // 20
		
		AtomicInteger intVal1 = new AtomicInteger();		
		System.out.println(intVal1.getAndIncrement()); // 0
		System.out.println(intVal1.incrementAndGet()); // 2
		intVal1.set(123);
		System.out.println(intVal1.get()); // 123
		
		//compare and set 
		AtomicInteger atomicInteger = new AtomicInteger(123);
		int expectedValue = 123;
		int newValue      = 234;
		atomicInteger.compareAndSet(expectedValue, newValue);
		System.out.println(atomicInteger.get()); // 234


		AtomicInteger intVal2 = new AtomicInteger(1);		
		System.out.println(intVal2.getAndDecrement()); // 1
		System.out.println(intVal2.decrementAndGet()); // -1
		
	}

}
