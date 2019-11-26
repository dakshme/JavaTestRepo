package com.bmc.practice.datastructures;

import java.util.ArrayList;

public class MergingTwoSortedArrays {

	public static void main(String[] args) {
		
		int arr1[] = {1,7,15,25,36,45};
		int arr2[] = {3,5,8,10,56,100,786};
		
		ArrayList<Integer> intList = new ArrayList<>();
		
		int i=0,j=0;
		while (i<arr1.length && j<arr2.length) {
			
			if(arr1[i]<arr2[j]) {
				
				intList.add(arr1[i]);
				i++;				
			} else {
				intList.add(arr2[j]);
				j++;
			}
		}
		
		//put remaining elements of arr1 from index i into final list
		while (i<arr1.length) {
			intList.add(arr1[i]);
			i++;
		}
			
		//put remaining elements of arr2 from index j into final list
		while (j<arr2.length) {
			intList.add(arr2[j]);
			j++;
		}
		
		System.out.println("Merged array is "+intList);
	}
}
