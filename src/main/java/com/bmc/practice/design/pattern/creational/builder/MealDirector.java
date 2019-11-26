package com.bmc.practice.design.pattern.creational.builder;

//In order to kick off the build process, we have a director: 
//Director
public class MealDirector {
	
	 public Meal createMeal(MealBuilder builder) {
		    builder.buildDrink();
		    builder.buildMain();
		    builder.buildDessert();
		    return builder.getMeal();
		  }
}
