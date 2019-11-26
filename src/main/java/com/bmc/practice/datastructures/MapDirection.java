package com.bmc.practice.datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MapDirection {

	class Pair {
		int x;
		int y;
		
		public Pair (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		
		ArrayList<Pair> cordinates = new ArrayList<>();
		MapDirection map = new MapDirection();
		
		cordinates.add(map.new Pair(0,0));
		cordinates.add(map.new Pair(1,0));
		cordinates.add(map.new Pair(2,0));
		cordinates.add(map.new Pair(3,0));
		cordinates.add(map.new Pair(3,1)); //turn left on y
		cordinates.add(map.new Pair(3,2));
		cordinates.add(map.new Pair(4,2)); // turn right on x
		cordinates.add(map.new Pair(4,1));// turn right on y (-native side)
		cordinates.add(map.new Pair(4,0));
		cordinates.add(map.new Pair(4,-1));
		
		List<String> directionDetails = map.getDirection(cordinates);
		
		System.out.println(directionDetails.toString());
	}

	private List<String> getDirection(ArrayList<Pair> cordinates) {

		LinkedList<String> directionDetails = new LinkedList<>();
		
		int distanceX = 0;
		int distanceY = 0;
		
		boolean movingX = false;
		boolean movingY = false;;
		Pair previousPair = null;
		
		for (Pair p : cordinates) {
			
			if (null != previousPair && (previousPair.x != p.x) ) { // moving only in x direction
				
				if (movingY) { // turn towards y axis
					
					movingY=false;
					directionDetails.add("Straight "+distanceY+" meters");
					distanceY=0;//rest
					if (previousPair.x < p.x)
						directionDetails.add("Turn Right");
					else
						directionDetails.add("Turn Left");					
				}
				
				movingX = true;
				distanceX = distanceX + 1; //keep moving by 1mtr
			}
			
			if (null != previousPair && previousPair.y != p.y ) { // moving only in y direction
				
				if (movingX) { // turn towards y axis					
					movingX=false;
					directionDetails.add("Straight "+distanceX+" meters");
					distanceX=0; // reset
					if (previousPair.y < p.y)
						directionDetails.add("Turn Left");
					else
						directionDetails.add("Turn Right");	
				}		
				
				movingY= true;				
				distanceY = distanceY + 1; //keep moving by 1mtr
			}
			previousPair = p;
		}
		
		//last condition for the remaining straight distance traveled
		if (movingX)
			directionDetails.add("Straight "+distanceX+" meters");
		else if (movingY)
			directionDetails.add("Straight "+distanceY+" meters");

		return directionDetails;
	}
}
