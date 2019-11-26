package com.bmc.practice.datastructures;

public class IslandOnlyRectangular {

	public static void main(String[] args) {

    int x = 4;
    int y = 7;
    
    int c = 0;
    
    int[][] mat = {
    		       {0,1,0,0,0,0,0},
    		       {1,1,0,1,0,1,0},
    		       {0,0,0,1,0,1,0},
    		       {1,1,1,1,0,0,0}
    		      };
    
    for(int i=0;i<x;i++) {
    	for(int j=0;j<y;j++) {
    		
    		if(mat[i][j] == 1){
    			if((i==0 || mat[i-1][j] == 0) && (j==0 || mat[i][j-1] == 0))
    				c++;
    		}
    		
    	}
    }
    
    System.out.println("No. of islands found is "+c);

	}

}
