package com.bmc.practice.design.pattern.creational.factory.shapeFactory;

public class Circle implements Shape {

	   @Override
	   public void draw() {
	      System.out.println("Inside Circle::draw() method.");
	   }
}