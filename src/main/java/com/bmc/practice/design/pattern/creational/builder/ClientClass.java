package com.bmc.practice.design.pattern.creational.builder;


//Integration with overall application
public class ClientClass {
	
	public static void main(String[] args) {
		
	    MealDirector director = new MealDirector();
	    
	    MealBuilder builder = null;
	    
	    if (isKid) {
	      builder = new KidsMealBuilder();
	    }
	    else{
	      builder = new AdultMealBuilder();
	    }
	    
	    Meal meal = director.createMeal(mealBuilder);
	  }

}
