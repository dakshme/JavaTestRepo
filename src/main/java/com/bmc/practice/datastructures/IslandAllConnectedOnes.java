package com.bmc.practice.datastructures;

public class IslandAllConnectedOnes {
	
	public int countIslands(int [][] grid){
		
		int count = 0;
		
		for(int i=0; i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				if(grid[i][j] == 1) {
					count++;
					changeOneToZero(grid, i, j);
				}
			}
		}		
		return count;		
	}
	
	private void changeOneToZero(int[][] grid, int i, int j){
		
		//base conditions for boundary checks and check if grid[i][j]=0
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0) return;
		
		//Here we are sure grid[i][j]=1 , hence change it to 0
		grid[i][j] = 0;
		
		changeOneToZero(grid,i-1,j);
		changeOneToZero(grid,i+1,j);
		changeOneToZero(grid,i,j-1);
		changeOneToZero(grid,i,j+1);		
	}

	public static void main(String[] args) {

     int[][] grid = {
    		
  		       {0,1,0,0,0,0,0},
  		       {1,1,0,1,0,1,0},
  		       {0,0,0,1,0,1,0},
  		       {1,1,1,1,0,0,0}
  		      };
    		 		 /* {1,1,1,0,1},
    		          {1,1,0,0,0},
    		          {0,0,0,1,1},
    		          {1,0,1,0,0}    		 
                    };*/
     
     IslandAllConnectedOnes ins = new IslandAllConnectedOnes();
     
     System.out.println("No. of islands is "+ins.countIslands(grid));

	}

}
