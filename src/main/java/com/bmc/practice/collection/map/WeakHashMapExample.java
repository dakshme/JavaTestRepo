package com.bmc.practice.collection.map;

import java.util.WeakHashMap;

public class WeakHashMapExample {

	public static void main(String[] args) throws InterruptedException {
	      WeakHashMap<Temp, String> m = new WeakHashMap<>();
	      Temp t = new Temp();
	      m.put(t, "King");
	      System.out.println(m);  //{temp=King}
	      t = null;
	      System.gc();
	      Thread.sleep(5000);
	      System.out.println(m);  // {}
	   }
}

class Temp {
   public String toString() {
      return "temp";
   }
   public void finalize() {
      System.out.println("Finalize method called");
   }
}
