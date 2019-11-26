package com.bmc.practice.design.pattern.creational.factory.shapeFactory;

public class Square implements Shape {

	   @Override
	   public void draw() {
	      System.out.println("Inside Square::draw() method.");
	   }
}