package com.bmc.practice.datastructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FindCommoninArrays {

	public static void main(String[] args) {

	int arr1[] = {2,78,98,1,3,45,786};
	int arr2[] = {12,55,8,2,9,57,1009,786,98};
	HashMap map = new HashMap();
	
	int l = arr1.length > arr2.length ? arr1.length : arr2.length;
	
	System.out.println("Max length is "+l);
	
	for(int i=0;i<l;i++) {
		if(i<arr1.length) {
			if(map.get(arr1[i]) == null)
				map.put(arr1[i], 1);
			else
				map.put(arr1[i], (Integer)map.get(arr1[i])+1);
		}
		if(map.get(arr2[i]) == null)
			map.put(arr2[i], 1);
		else
			map.put(arr2[i], (Integer)map.get(arr2[i])+1);
	}
	
	System.out.println("Map is : "+map);
		
	Set itset = map.keySet();
	Iterator it = itset.iterator();
	
	while(it.hasNext()) {
		
		Integer itkey = (Integer) it.next();
		if((Integer)map.get(itkey) > 1)
			System.out.println(itkey);
	}
	
	

	}

}
